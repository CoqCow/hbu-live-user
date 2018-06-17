package com.hbu.live.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser(){
        return  ResponseEntity.ok().body("真棒，看到这个，说明user模块接口调通");
    }
}
t s