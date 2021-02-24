package com.association.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.association.platform.mapper")
@SpringBootApplication
public class EmergencyServicePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmergencyServicePlatformApplication.class, args);
    }
}
