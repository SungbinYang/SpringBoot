package me.sungbin.webservershowcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/hello")
    public String hello() {
        return "hello Spring";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public ServletWebServerFactory serverFactory() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//
//        return tomcat;
//    }
//
//    private Connector createStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(8080);
//
//        return connector;
//    }

}
