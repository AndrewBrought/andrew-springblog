//package com.codeup.springblog.controllers;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class DashboardController {
//
//    @Value("${phoneNumber}")
//    private String phoneNumber;
//
//    @GetMapping("/dashboard")
//    public ModelAndView showDashboard() {
//        ModelAndView dashboard = new ModelAndView("dashboard");
//        dashboard.addObject("phoneNumber", phoneNumber);
//        return dashboard;
//    }
//
//}
