package com.hbu.live.user.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private int userId;
    private String organizationName;
    private int number;
    private String password;
    private String name;
    private String college;
    private String nickName;
    private String avatar;
    private String signature;
    private String phoneNumber;
    private int whetherAnchor;
    private int followNumber;
    private Date registrationTime;
}
