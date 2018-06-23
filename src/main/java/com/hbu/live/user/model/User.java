package com.hbu.live.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.cfg.ImprovedNamingStrategy;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userId;
    @Column(name = "organizationname")
    private String organizationName;
    private int number;
    private String password;
    private String name;
    private String college;
    @Column(name = "nickname")
    private String nickName;
    private String avatar;
    private String signature;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "whetheranchor")
    private int whetherAnchor;
    @Column(name = "follownumber")
    private int followNumber;
    @Column(name = "registrationtime")
    private Date registrationTime;

}
