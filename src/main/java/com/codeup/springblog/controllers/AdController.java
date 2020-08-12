//package com.codeup.springblog.controllers;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//public class AdController {

    // ======================= version WITHOUT form model binding
//    @GetMapping("/ads/create")
//    public String showCreateForm() {
//        return "ads/create";
//    }
//    @PostMapping("/ads/create")
//    @ResponseBody
//    public String create(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description
//    ) {
//        Ad ad = new Ad();
//        ad.setTitle(title);
//        ad.setDescription(description);
//        // save the ad...
//        return "Ad saved!";
//    }

//
//============================== Form Model Binding ========

//    @GetMapping("/ads/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("ad", new Ad());
//        return "ads/create";
//    }
//
//    @PostMapping("/ads/create")
//    public String createAd(@ModelAttribute Ad ad) {
//        adsDao.save(ad);
//        return "redirect:/ads/view";
//    }

//
//}
