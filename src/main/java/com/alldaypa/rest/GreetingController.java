package com.alldaypa.rest;

import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Binky
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        log.info("I'm in greeting()");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    // http://localhost:8080/hello?name=Binky
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name") String name) {

        log.info("I'm in hello()");
        return "Hello " + name;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String index() {
        log.info("I'm in index()");
        return "Hello";
    }
}