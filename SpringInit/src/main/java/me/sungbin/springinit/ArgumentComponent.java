package me.sungbin.springinit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgumentComponent {

    public ArgumentComponent(ApplicationArguments arguments) {
        System.out.println("foo: " + arguments.containsOption("foo"));
        System.out.println("bar: " + arguments.containsOption("bar"));
    }
}
