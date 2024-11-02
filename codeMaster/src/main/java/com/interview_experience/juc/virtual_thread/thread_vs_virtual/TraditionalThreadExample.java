package com.interview_experience.juc.virtual_thread.thread_vs_virtual;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:Tamako
 * @Date:2024/8/15 14:00
 * @Description:TODO
 */
public class TraditionalThreadExample {
    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(30000);
        long startTime = System.currentTimeMillis();

        AtomicInteger counter = new AtomicInteger(0);
        Thread[] threads = new Thread[100000];

        for (int i = 0; i < 100000; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    counter.incrementAndGet();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Traditional threads execution time: " + (endTime - startTime) + " ms");
//        Thread.sleep(10000000);
    }
}
