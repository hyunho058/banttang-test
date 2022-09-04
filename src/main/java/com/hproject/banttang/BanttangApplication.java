package com.hproject.banttang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //JPA Auditing 활성화
@ConfigurationPropertiesScan
@SpringBootApplication
public class BanttangApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanttangApplication.class, args);
    }

}
