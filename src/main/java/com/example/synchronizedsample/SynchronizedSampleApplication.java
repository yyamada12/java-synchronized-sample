package com.example.synchronizedsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SynchronizedSampleApplication implements ApplicationRunner {

    private final Counter counter;

    public SynchronizedSampleApplication(Counter counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        SpringApplication.run(SynchronizedSampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var l = new ArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            int i_ = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                l.add(i_);
            });
            thread.start();
        }

        // Wait for all threads to finish
        Thread.sleep(1000);

        System.out.println("Main Thread Finish");
        System.out.println("num of list: " + l.size());
    }

}
