package com.example.synchronizedsample;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
            count.getAndIncrement();
    }

    public int getCount() {
        return count.get();
    }
}
