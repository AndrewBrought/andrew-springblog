package com.codeup.springblog.services;

import com.codeup.springblog.config.TwilioConfig;
import com.codeup.springblog.models.SmsRequest;
import com.codeup.springblog.repositories.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsSender implements SmsSender {

    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioSmsSender(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTwilioNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,
                    from,
                    message
            );
            creator.create();
        } else {
            throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number ");
        }
    }
// TODO: Implement Google Phone number validator
    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
