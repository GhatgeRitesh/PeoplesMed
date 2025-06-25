package com.FrontEnd.CustomerService.Controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

@RestController
@RequestMapping("/chatbot")
@Log
public class chatbotcontroller {

    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";
    @Value("${chatbot.apiKey}")
    private static String getApiKey;
    private static final String API_KEY = getApiKey;

    private static final List<String> allowedKeywords = List.of(
            // Core medical terms
            "doctor", "hospital", "clinic", "health", "healthcare", "appointment", "emergency",
            "patient", "treatment", "medicine", "medication", "specialist", "nurse", "surgeon",
            "icu", "ot", "diagnosis", "symptom", "ambulance", "checkup", "consultation",
            "prescription", "pharmacy", "scan", "x-ray", "blood test", "lab test",
            "vaccination", "covid", "fever", "pain", "infection", "injury", "report",
            "mental health", "therapy", "counseling", "referral",
            "doctor availability", "timing", "opening hours", "insurance", "surgery",
            "emergency room", "health issue", "medical report",

            // Departments
            "cardiology", "neurology", "orthopedic", "gynecology", "pediatrics",
            "dermatology", "urology", "ent", "dentist", "diabetes", "eye doctor", "skin doctor",

            // Common/language-neutral words people use
            "medicine shop", "chemist", "hospital near me", "doctor near me",
            "pain in chest", "headache", "cold", "cough", "vomiting", "loose motion",
            "back pain", "knee pain", "body ache", "tired", "weak", "not feeling well",
            "appointment booking", "need ambulance", "urgent help", "emergency help",
            "where to go", "nearest clinic", "free checkup", "govt hospital",
            "health card", "modicare", "ayushman", "test report", "test result",

            // Phonetically typed variations (as often typed in India)
            "dr", "hosp", "med", "xray", "feaver", "docter", "emergncy", "dctr", "nurs",
            "injekshan", "pain killer", "bimar", "bimari", "bimaar", "tablat", "dawai"
    );
    @PostMapping("/ask")
    public ResponseEntity<String> chat(@RequestBody Map<String, String> body) {
        try {
            log.info("api hit successfully");
            String userMessage = body.get("message");
            if (isHealthcareQuery(userMessage)) {
                String reply = callGeminiApi(userMessage);
                log.info("Response Generated Successfully");
                return ResponseEntity.ok(reply);
            } else {
                return ResponseEntity.ok("Sorry, I can only assist with health, hospital, doctor, or emergency-related queries.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }


    private boolean isHealthcareQuery(String message) {
            String lower = message.toLowerCase();
            return allowedKeywords.stream().anyMatch(lower::contains);
        }



    private String callGeminiApi(String message) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        log.info("Calling to geminiapi");

        String requestBody = """
    {
      "contents": [
        {
          "role": "user",
          "parts": [
            {
              "text": "%s"
            }
          ]
        }
      ]
    }
    """.formatted(message.replace("\"", "\\\""));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GEMINI_URL + "?key=" + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Response Status: " + response.statusCode());
        log.info("Response Body: " + response.body());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Gemini API Error: " + response.body());
        }

        // Extracting just the text response
        JSONObject obj = new JSONObject(response.body());
        String replyText = obj.getJSONArray("candidates")
                .getJSONObject(0)
                .getJSONObject("content")
                .getJSONArray("parts")
                .getJSONObject(0)
                .getString("text");

        return replyText;
    }


}
