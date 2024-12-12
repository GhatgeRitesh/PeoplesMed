    package com.FrontEnd.CustomerService.Controllers;

    import com.FrontEnd.CustomerService.Configurations.currDoctor;
    import com.FrontEnd.CustomerService.EntityManager.Mail.MeetingDetails;
    import com.FrontEnd.CustomerService.EntityManager.Users.BookedSchedules;
    import com.FrontEnd.CustomerService.EntityManager.Users.Patient;
    import com.FrontEnd.CustomerService.FeignServices.DatabaseService;
    import com.FrontEnd.CustomerService.FeignServices.MailService;
    import com.FrontEnd.CustomerService.Service.PatientService;
    import com.FrontEnd.CustomerService.Service.ZoomService;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import feign.FeignException;
    import jakarta.servlet.http.HttpSession;
    import lombok.extern.java.Log;
    import okhttp3.*;
    import okhttp3.RequestBody;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import com.FrontEnd.CustomerService.Configurations.currUser;
    import org.springframework.web.servlet.ModelAndView;

    import java.io.IOException;



    @Controller
    @Log
    public class ZoomController {
        @Autowired
        private PatientService patientService;

        @Autowired
        private MeetingDetails meetingDetails;

        @Autowired
        private currUser currUser;

        @Autowired
        private MailService mailService;

        @Value("${zoom.api.url}")
        private String apiUrl;

        @Value("${zoom.clientId}")
        private String clientId;

        @Value("${zoom.clientSecret}")
        private String clientSecret;

        @Value("${zoom.redirectUri}")
        private String redirectUri;

        @Value("${zoom.tokenUrl}")
        private String tokenUrl;

        @Autowired
        private ZoomService zoomService;

        @Autowired
        private currDoctor currDoctor;

        @Autowired
        private BookedSchedules bookedSchedules;

        @Autowired
        private DatabaseService databaseService;

        @GetMapping("/P/ZoomNotice")
        public ModelAndView notice(ModelAndView mv){
            log.info("Notice Page Activated");
            mv.setViewName("Notice");
            return mv;
        }

        @GetMapping("/P/zoom/authorize")
        public String authorize(HttpSession session) {

            //checking the Visited patient or not
            if(session.getAttribute("VisitedZoomAPI") !=null){return "redirect:/P/linkGenerated";}

            session.setAttribute("VisitedZoomAPI", "visited");

            System.out.println("Entered into zoom authorize");
            String url = "https://zoom.us/oauth/authorize?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUri;
            return "redirect:" + url;
        }

        @GetMapping("/zoom/oauthredirect")
        public String oauthRedirect(@RequestParam("code") String code, Model model, HttpSession session) throws IOException {
            // here instead of taking the form input i need to implicitly declare the id and Message and call the create meeting method retrieve the entity and fetch them with mail

            System.out.println(session.getAttribute("VisitedZoomAPI"));
            // set the User Mail and Meeting Topic
            String Mail ="riteshghatge12345@gmail.com";


            bookedSchedules = (BookedSchedules) session.getAttribute("schedule");
            Patient p= patientService.getCurrUser(currUser.getMail());

            String MeetingTopic= "Consultation meeting of Doctor: Dr."+ currDoctor.getDoctorName() + " and  Patient :" +currUser.getName() +" for Concern of Patient as : " + bookedSchedules.getDescription();
            System.out.println("schedule is saved in session " + bookedSchedules.toString());
            System.out.println("Auth redirect Hit ✅");
            String token = zoomService.getAccessToken(code);
            session.setAttribute("accessToken", token);
            meetingDetails= (MeetingDetails) createMeeting(session,currUser.getMail(), MeetingTopic).getBody();
            meetingDetails.setPmail(currUser.getMail());
            meetingDetails.setDname(currDoctor.getDoctorName());
            meetingDetails.setPname(currUser.getName());
            meetingDetails.setDmail(currDoctor.getDoctorEmail());
            log.info(meetingDetails.toString());
            // curr schedule not null
            bookedSchedules.setPId(p.getP_id());
            bookedSchedules.setDId(currDoctor.getDoctorId());
            bookedSchedules.setLink(meetingDetails.getJoin_url());
            bookedSchedules.setStatus("Pending");
            bookedSchedules.setDocName(currDoctor.getDoctorName());
            bookedSchedules.setPatName(currUser.getName());

            meetingDetails.setStart_time(bookedSchedules.getSlotTime()+" on date:"+ bookedSchedules.getSlotDate());

            //saving the schedule
            try {
                log.info("saving bookedSchedule");
                databaseService.saveSchedule(bookedSchedules);
                databaseService.updateASchedule(bookedSchedules);
                log.info("saved");
            }
            catch(FeignException.FeignClientException e){
                log.info("Exception occured while saving schedule :" + e);
            }
            // send the meeting links to the mail and save them into database
            log.info("sending mails");
            mailService.MeetingDetailsMail(meetingDetails);
            log.info("mails sent successful");
//            System.out.println("after update the meeting details are:" + meetingDetails.toString() );
//            System.out.println("after update the schedules details are:" + bookedSchedules.toString());

            return "redirect:/P/linkGenerated";
        }



        @PostMapping("/createMeeting")
        public ResponseEntity<?> createMeeting(HttpSession session,
                                          String userId,
                                          String topic
                                    ) throws IOException {
            // Retrieve the access token from session
            String accessToken = (String) session.getAttribute("accessToken");

            if (accessToken == null) {
                throw new IOException("Access token is missing. Please authorize the application first.");
            }

            OkHttpClient httpClient = new OkHttpClient();
            String url = apiUrl + "/users/" + userId + "/meetings";
            String json = String.format("{\"topic\": \"%s\", \"type\": 2}", topic);

            okhttp3.RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Authorization", "Bearer " + accessToken)
                    .addHeader("Content-Type", "application/json")
                    .build();

            try (Response response = httpClient.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    String meetingResponse = response.body().string();
                    ObjectMapper objectMapper = new ObjectMapper();
                    MeetingDetails meetingDetails = objectMapper.readValue(meetingResponse, MeetingDetails.class);
    //                model.addAttribute("meetingDetails", meetingDetails);    // Display meeting details in view
                    return new ResponseEntity<>(meetingDetails,HttpStatus.OK);  // Replace with your view page to show meeting info
                } else {
                    // Log error response details
                    String errorMessage = response.body() != null ? response.body().string() : "No response body";
                    System.err.println("Error creating meeting. Response code: " + response.code() + ", Message: " + errorMessage);
                    throw new IOException("Error creating meeting: " + response.message() + " - " + errorMessage);
                }
            }
        }
    }
