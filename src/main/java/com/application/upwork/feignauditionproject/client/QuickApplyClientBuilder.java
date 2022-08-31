package com.application.upwork.feignauditionproject.client;

import com.application.upwork.feignauditionproject.service.QuickApplyClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

@Getter
public class QuickApplyClientBuilder {

    private QuickApplyClient quickApplyClient = createClient(QuickApplyClient.class, "https://partners.apploi.com/v1/application");

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, uri);
    }

}
