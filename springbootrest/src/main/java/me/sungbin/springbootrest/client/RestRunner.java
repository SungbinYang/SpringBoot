package me.sungbin.springbootrest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        RestTemplate restTemplate = restTemplateBuilder.build();
        WebClient webClient = builder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // TODO: /hello
        String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
        System.out.println(helloResult);

        //TODO: /world
        String worldResult = restTemplate.getForObject("http://localhost:8080/world", String.class);
        System.out.println(worldResult);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        Mono<String> stringMono = webClient.get().uri("/hello").retrieve().bodyToMono(String.class);
        stringMono.subscribe(s -> {
            System.out.println(s);

            if (stopWatch1.isRunning()) {
                stopWatch1.stop();
            }
            System.out.println(stopWatch1.prettyPrint());
            stopWatch1.start();
        });

        Mono<String> stringMono1 = webClient.get().uri("/world").retrieve().bodyToMono(String.class);
        stringMono1.subscribe(s -> {
            System.out.println(s);

            if (stopWatch1.isRunning()) {
                stopWatch1.stop();
            }
            System.out.println(stopWatch1.prettyPrint());
            stopWatch1.start();
        });
    }
}
