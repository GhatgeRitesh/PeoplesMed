package com.FrontEnd.CustomerService.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log
public class ZoomService {
    @Value("${zoom.clientSecret}")
    private String clientSecret;

    @Value("${zoom.redirectUri}")
    private String redirectUri;

    @Value("${zoom.tokenUrl}")
    private String tokenUrl;

    @Value("${zoom.clientId}")
    private String clientId;

    public  String getAccessToken(String code) throws IOException {
        System.out.println("get Access Token Hit ✅");
        OkHttpClient client = new OkHttpClient();
        String credentials = Credentials.basic(clientId, clientSecret);

        FormBody formBody = new FormBody.Builder()
                .add("grant_type", "authorization_code")
                .add("code", code)
                .add("redirect_uri", redirectUri)
                .build();

        Request request = new Request.Builder()
                .url(tokenUrl)
                .post(formBody)
                .addHeader("Authorization", credentials)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                //System.out.println(json);
                JsonNode node = new ObjectMapper().readTree(json);
                return node.get("access_token").asText();
            } else {
                throw new IOException("Failed to retrieve access token");
            }
        }
    }
}
