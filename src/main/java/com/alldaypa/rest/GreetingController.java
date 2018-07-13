package com.alldaypa.rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Binky
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    // http://localhost:8080/hello?name=Binky
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name") String name) {

        return "Hello " + name;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String index() {
        return "Hello";
    }
}