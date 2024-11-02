package com.interview_experience.juc;

/**
 * @Author:Tamako
 * @Date:2024/8/30 10:58
 * @Description:TODO
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockFreeCacheTest {
    private static final int CACHE_SIZE = 100;
    private static final int READ_THREAD_COUNT = 100;
    private static final int WRITE_THREAD_COUNT = 10;
    private static final int OPERATIONS_PER_THREAD = 1000;

    public static void main(String[] args) throws InterruptedException {
        LockFreeCache cache = new LockFreeCache(CACHE_SIZE);
        ExecutorService executorService = Executors.newFixedThreadPool(READ_THREAD_COUNT + WRITE_THREAD_COUNT);
        CountDownLatch latch = new CountDownLatch(READ_THREAD_COUNT + WRITE_THREAD_COUNT);

        // 初始化缓存内容
        for (int i = 0; i < CACHE_SIZE; i++) {
            cache.write(i, ("InitialData" + i).getBytes());
        }

        // 启动读线程
        for (int i = 0; i < READ_THREAD_COUNT; i++) {
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        int index = (int) (Math.random() * CACHE_SIZE);
                        byte[] data = cache.read(index);
                        // 可以添加一些简单的验证逻辑，比如验证数据非空
                        if (data == null) {
                            System.out.println("Read returned null at index: " + index);
                        }
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        // 启动写线程
        for (int i = 0; i < WRITE_THREAD_COUNT; i++) {
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        int index = (int) (Math.random() * CACHE_SIZE);
                        String newData = "NewData" + index + "-" + j;
                        cache.write(index, newData.getBytes());
                    }
                } finally {
                    latch.countDown();
                }
            });
        }

        // 等待所有线程完成
        latch.await();
        executorService.shutdown();

        // 简单验证缓存结果
        for (int i = 0; i < CACHE_SIZE; i++) {
            System.out.println("Cache at index " + i + ": " + new String(cache.read(i)));
        }

        System.out.println("Test completed.");
    }
}

