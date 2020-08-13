package com.codeup.springblog.repositories;

import com.codeup.springblog.models.SmsRequest;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
}
