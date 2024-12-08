    package com.FrontEnd.Web_InterFace.Controllers;

    import com.FrontEnd.Web_InterFace.Configurations.currDoctor;
    import com.FrontEnd.Web_InterFace.EntityManager.Mail.MeetingDetails;
    import com.FrontEnd.Web_InterFace.EntityManager.Users.Patient;
    import com.FrontEnd.Web_InterFace.FeignServices.FeaturesService;
    import com.FrontEnd.Web_InterFace.Service.ZoomService;
    import com.fasterxml.jackson.databind.ObjectMapper;
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
    import com.FrontEnd.Web_InterFace.Configurations.currUser;
    import org.springframework.web.servlet.ModelAndView;

    import java.io.IOException;


    @Controller
    @Log
    public class ZoomController {
        @Autowired
        private Patient patient;

        @Autowired
        private MeetingDetails meetingDetails;

        @Autowired
        private currUser currUser;

        @Autowired
        private FeaturesService featuresService;

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

        @GetMapping("/ZoomNotice")
        public ModelAndView notice(ModelAndView mv){
            log.info("Notice Page Activated");
            mv.setViewName("Notice");
            return mv;
        }

        @GetMapping("/zoom/authorize")
        public String authorize() {
            System.out.println("Entered into zoom authorize");
            String url = "https://zoom.us/oauth/authorize?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUri;
            return "redirect:" + url;
        }

        @GetMapping("/zoom/oauthredirect")
        public String oauthRedirect(@RequestParam("code") String code, Model model, HttpSession session) throws IOException {
            // here instead of taking the form input i need to implicitly declare the id and Message and call the create meeting method retrieve the entity and fetch them with mail

            System.out.println(currUser.getMail());
            // set the User Mail and Meeting Topic
            String Mail ="riteshghatge12345@gmail.com";
            String MeetingTopic = "Virtual Consultation";

            System.out.println("Auth redirect Hit ✅");
            String token = zoomService.getAccessToken(code);
            session.setAttribute("accessToken", token);
            meetingDetails= (MeetingDetails) createMeeting(session,currUser.getMail(), MeetingTopic).getBody();
            meetingDetails.setPmail(currUser.getMail());
            meetingDetails.setDname(currDoctor.getDoctorName());
            meetingDetails.setPname(currUser.getName());
            meetingDetails.setDmail(currDoctor.getDoctorEmail());
            log.info(meetingDetails.toString());

            // send the meeting links to the mail and save them into database
            featuresService.MeetingDetailsMail(meetingDetails);

            return "redirect:/P/shareMeetingDetails";
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
