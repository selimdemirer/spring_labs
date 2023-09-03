package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String getProfile(Model model){

        Profile person = new Profile();

        person.setName("Harold");
        person.setSurname("Finch");
        person.setUserName("admin");
        person.setPhoneNumber("2027909045");
        person.setEmail("admin@cydeo.com");
        person.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile",person);

        return "profile/profile-info";
    }
}
