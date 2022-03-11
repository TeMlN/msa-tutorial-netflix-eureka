package com.example.MSAClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class RpcController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_B_NAME = "SERVICE-B";

    @GetMapping("/rpc/test")
    public String callServiceB() {
        ResponseEntity<String> ackMessage;
        String apiPath = "/api/health-check";

        ackMessage = restTemplate.getForEntity("http://" + SERVICE_B_NAME + apiPath, String.class);

        return "Service-A: inst001 호출" + " > " + ackMessage.getBody();
    }

}
