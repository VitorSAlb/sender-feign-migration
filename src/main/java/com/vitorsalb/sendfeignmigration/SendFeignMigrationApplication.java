package com.vitorsalb.sendfeignmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SendFeignMigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendFeignMigrationApplication.class, args);
    }

}
