package com.sparta.sparta_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.json.GsonBuilderUtils;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaCloneApplication.class, args);

//        String len = "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/s320x320/27575573_354717225010814_8831437854275010560_n.jpg?tp=1&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_ohc=OUsjN0_u8MgAX--ZkwQ&edm=ABfd0MgAAAAA&ccb=7-4&oh=9476a58f26b11f59a290044d35d50d84&oe=608FDE56&_nc_sid=7bff83";
//
//        int length = len.length();
//
//        System.out.println(length);
    }

}
