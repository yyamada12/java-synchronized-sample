package com.example.synchronizedsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final Counter counter;

    SampleController(Counter counter) {
        this.counter = counter;
    }

    @GetMapping("/")
    public int sample() {
        counter.increment();
        return counter.getCount();
    }
}
