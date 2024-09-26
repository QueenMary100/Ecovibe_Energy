package com.example.biogas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Service
public class AfricasTalkingService {

    private final String apiKey = "YOUR_API_KEY";
    private final String username = "YOUR_USERNAME";

    private RestTemplate restTemplate = new RestTemplate();

    public void sendSms(String phoneNumber, String message) {
        String url = "https://api.africastalking.com/version1/messaging";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("to", phoneNumber);
        params.put("message", message);

        StringBuilder body = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            body.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);

        // Send request
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class
        );

        System.out.println("Response from Africa's Talking: " + response.getBody());
    }
}
