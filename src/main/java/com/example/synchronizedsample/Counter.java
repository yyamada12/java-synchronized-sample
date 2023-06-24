package com.example.synchronizedsample;

import org.springframework.stereotype.Component;

@Component
public class Counter {
    private int count = 0;

    public synchronized void increment() {
            count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
