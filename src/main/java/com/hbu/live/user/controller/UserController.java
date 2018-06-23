package com.hbu.live.user.controller;

import com.hbu.live.user.model.User;
import com.hbu.live.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUser() {
        User user = null;
        user = userService.getUserByUserId(1);
        return ResponseEntity.ok().body(user);
    }
}