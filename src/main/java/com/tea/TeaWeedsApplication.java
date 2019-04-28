package com.tea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.transaction.annotation.Transactional;

@EnableCaching  //开启缓存
@SpringBootApplication
public class TeaWeedsApplication {


    public static void main(String[] args) {
        SpringApplication.run(TeaWeedsApplication.class, args);
    }

}
