package com.hbu.live.user;

import com.hbu.live.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HbuLiveUserApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {
        System.out.println("user:"+userService.getUserByUserId(1).toString());
    }

}
