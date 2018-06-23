package com.hbu.live.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class HbuLiveUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbuLiveUserApplication.class, args);
    }

    @Component
    public static class Config {

        @Value("${jwt.secret}")
        public String jwtSecret;
    }

}
