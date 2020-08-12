package com.codeup.springblog.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingSvc {
//    Want this to have a bunch of methods that take in a name and return a greeting...

    public String goodMorning(String name) {
        return "Good morning, " + name + "!";
    }

    public String goodAfternoon(String name) {
        return "Good afternoon, " + name + "!";
    }

    public String goodEvening(String name) {
        return "Good evening, " + name + "!";
    }

}
