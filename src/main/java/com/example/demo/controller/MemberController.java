package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/profile")
    public Profile profile(){
        return new Profile("김재아",24);
    }

    record Profile(String name, int age){}
}
