package me.sungbin.springinit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:/test.properties")
class AppTest {

    @Autowired
    Environment environment;

    @Test
    void contextLoads() {
        assertEquals(environment.getProperty("sungbin.fullName"), "War");
    }

}
