package me.sungbin.app;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpringbootmonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmonitorApplication.class, args);
    }

}
