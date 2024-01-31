package com.example.activitiinterviewprocess.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    private final RestTemplate restTemplate;

    public InterviewController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startInterviewProcess(@RequestParam String interviewer) {
        // Define the Activiti REST API URL for starting a process instance
        String activitiUrl = "http://localhost:8080/activiti-rest/service/runtime/process-instances";

        // Prepare the request body as JSON
        String requestBody = "{ \"processDefinitionKey\": \"interviewProcess\", \"variables\": { \"interviewer\": \"" + interviewer + "\" } }";

        // Set the headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send the POST request to start the process instance
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                activitiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);

        // Return the response from the Activiti REST API
        System.out.println("Interview Process started");
        return ResponseEntity.ok(responseEntity.getBody());
    }
}
