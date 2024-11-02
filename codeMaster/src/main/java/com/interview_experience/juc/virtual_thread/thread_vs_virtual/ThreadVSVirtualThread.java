package com.interview_experience.juc.virtual_thread.thread_vs_virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:Tamako
 * @Date:2024/8/15 13:56
 * @Description:TODO
 */
public class ThreadVSVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        thread();
        virtualThread();
    }

    public static void thread() throws InterruptedException {
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
    }


    public static void virtualThread(){
        long startTime = System.currentTimeMillis();

        AtomicInteger counter = new AtomicInteger(0);

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100000; i++) {
                executor.submit(() -> {
                    for (int j = 0; j < 100000; j++) {
                        counter.incrementAndGet();
                    }
                });
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Virtual threads execution time: " + (endTime - startTime) + " ms");
    }
}
