package com.example.paycaptainirmarkcalculator.controller;

import com.example.paycaptainirmarkcalculator.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class NotificationController {

    @Autowired(required = true)
    private NotificationService notificationService;

    public String sendMessage(String xmlContent) throws Exception {
        notificationService.sendTestMessage(xmlContent);
        return "xmlContent send to process";
    }
}
