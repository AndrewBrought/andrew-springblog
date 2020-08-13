package com.codeup.springblog.services;

import com.codeup.springblog.models.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioServiceSvc {

    private final TwilioSmsSender twilioSmsSender;

    @Autowired
    public TwilioServiceSvc(TwilioSmsSender twilioSmsSender) {
        this.twilioSmsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        twilioSmsSender.sendSms(smsRequest);
    }

}
