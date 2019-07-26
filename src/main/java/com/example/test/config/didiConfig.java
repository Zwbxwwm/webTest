package com.example.test.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
//  clientId: "141b476b6c59a928cd7297ac15d0b74f_test"
//          clientSecret: "560c04df96cf65286f4b59f3307550f0"
//          masterPhone: "00016027412"
//          key: "a372D452";
//          url1:
@Data
@Component
@ConfigurationProperties("didi")
public class didiConfig {
    private String clientId;

    private String clientSecret;

    private String masterPhone;

    private String key;

    private String url1;


}
