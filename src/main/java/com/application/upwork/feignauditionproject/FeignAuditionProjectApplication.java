package com.application.upwork.feignauditionproject;

import com.application.upwork.feignauditionproject.service.QuickApplyClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeignAuditionProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(FeignAuditionProjectApplication.class, args);
    }

}
