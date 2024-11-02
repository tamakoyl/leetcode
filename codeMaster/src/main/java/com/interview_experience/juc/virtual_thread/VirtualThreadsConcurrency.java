package com.interview_experience.juc.virtual_thread;

import java.util.concurrent.Executors;

/**
 * @Author:Tamako
 * @Date:2024/8/15 13:42
 * @Description:大量虚拟线程并发执行任务
 */
public class VirtualThreadsConcurrency {
    public static void main(String[] args) throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " running in virtual thread");
                    try {
                        Thread.sleep(1000);  // 模拟任务处理时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            Thread.sleep(100000000);
        }  // 自动关闭 executor
    }




}
