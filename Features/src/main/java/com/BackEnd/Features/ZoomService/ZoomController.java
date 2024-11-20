package com.BackEnd.Features.ZoomService;

import com.BackEnd.Features.MailService.GMailEntity;
import com.BackEnd.Features.Models.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import okhttp3.*;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.BackEnd.Features.Models.MeetingDetails;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
public class ZoomController  {

    @Autowired
    private Patient patient;

    @Autowired
    private MeetingDetails meetingDetails;

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

    @PostMapping("/generateLink")
    public Boolean SendEmail(@org.springframework.web.bind.annotation.RequestBody GMailEntity gMailEntity) {
        return true;
    }
    @GetMapping("/zoom/authorize")
    public String authorize() {
        String url = "https://zoom.us/oauth/authorize?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUri;
        return "redirect:" + url;
    }

    @GetMapping("/zoom/oauthredirect")
    public ResponseEntity<?> oauthRedirect(@RequestParam("code") String code, Model model, HttpSession session) throws IOException {
        // here instead of taking the form input i need to implicitly declare the id and Message and call the create meeting method retrieve the entity and fetch them with mail


        // set the User Mail and Meeting Topic
        String Mail ="riteshghatge12345@gmail.com";
        String MeetingTopic = "Consultation";

        System.out.println("Auth redirect Hit ✅");
        String token = zoomService.getAccessToken(code);
        session.setAttribute("accessToken", token);
        System.out.println(createMeeting(session, Mail , MeetingTopic).toString());
       // model.addAttribute("accessToken", token);  // You might store this in session instead for easier access
        return new ResponseEntity<>(meetingDetails,HttpStatus.OK);
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