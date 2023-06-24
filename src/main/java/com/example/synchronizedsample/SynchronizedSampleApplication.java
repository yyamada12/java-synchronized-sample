package com.example.synchronizedsample;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SynchronizedSampleApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SynchronizedSampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (int i = 0; i < 30; i++) {
            var i_ = String.valueOf(i);
            Thread thread = new Thread(() -> {
                System.out.println(i_);
            });
            thread.start();
        }

        // Wait for all threads to finish
        Thread.sleep(1000);

        System.out.println("Main Thread Finish");
    }

}
