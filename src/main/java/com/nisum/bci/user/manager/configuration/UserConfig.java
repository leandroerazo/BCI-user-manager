package com.nisum.bci.user.manager.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "regex")
@Getter
@Setter
public class UserConfig {

    private String emailRegex;

    private String passwordRegex;
}
