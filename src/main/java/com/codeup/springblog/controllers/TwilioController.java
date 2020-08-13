package com.codeup.springblog.controllers;

import com.codeup.springblog.models.SmsRequest;
import com.codeup.springblog.services.TwilioServiceSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Provider;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    private final TwilioServiceSvc service;

    @Autowired
    public TwilioController(TwilioServiceSvc service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
            service.sendSms(smsRequest);
    }

}
