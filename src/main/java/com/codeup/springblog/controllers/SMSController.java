//package com.codeup.springblog.controllers;
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.json.GsonBuilderUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.List;
//
//@Controller
//public class SMSController {
//
//    public static class MessageDetails {
//        public List<String> numbers;
//        public String message;
//    }
//
//    @Value("${phoneNumber}")
//    private String myTwilioPhoneNumber;
//
//    @Autowired
//    public SMSController(
//            @Value("${twilioAccountSid}") String twilioAccountSid,
//            @Value("${twilioAuthToken}") String twilioAuthToken) {
//        Twilio.init(twilioAccountSid, twilioAuthToken);
//    }
//
//    @PostMapping("/send-messages")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void sendMessages(@RequestBody MessageDetails messageDetails) {
//
//        messageDetails.numbers.stream().forEach( number -> {
//            Message message = Message.creator(
//                    new PhoneNumber(number),
//                    new PhoneNumber(myTwilioPhoneNumber),
//                    messageDetails.message).create();
//            System.out.println(number);
//            System.out.println("Sent message w/ sid: " + message.getSid());
//        });
//
//    }
//}
