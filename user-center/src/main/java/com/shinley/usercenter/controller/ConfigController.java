package com.shinley.usercenter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
    @Value("${yourconfig}")
    private String yourConf;

    @GetMapping("/config")
    public String getConfig() {
        return yourConf;
    }
}
