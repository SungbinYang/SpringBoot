package me.sungbin.springinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    SungbinProperties sungbinProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("======================");
        System.out.println(sungbinProperties.getName());
        System.out.println(sungbinProperties.getAge());
        System.out.println(sungbinProperties.getSessionTimeout());
        System.out.println("======================");
    }
}
