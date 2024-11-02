package com.interview_experience.juc.virtual_thread.thread_vs_virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:Tamako
 * @Date:2024/8/15 14:00
 * @Description:TODO
 */
public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(30000);
        long startTime = System.currentTimeMillis();

        AtomicInteger counter = new AtomicInteger(0);

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10000; i++) {
                executor.submit(() -> {
                    for (int j = 0; j < 10000; j++) {
                        counter.incrementAndGet();
                    }
                });
            }
        }
        long endTime = System.currentTimeMillis();
//        Thread.sleep(10000000);
        System.out.println("Virtual threads execution time: " + (endTime - startTime) + " ms");
    }

}
