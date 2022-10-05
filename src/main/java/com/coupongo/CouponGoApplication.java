package com.coupongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CouponGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponGoApplication.class, args);
    }

}
