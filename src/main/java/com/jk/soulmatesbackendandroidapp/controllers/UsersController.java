package com.jk.soulmatesbackendandroidapp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @PostMapping("/createAll")
    private Boolean InsetUsers(){


        return true;
    }

    @PostMapping("/create")
    private Boolean insertUser(){
        //Somehow get the image and save the user
        return true;
    }



}
