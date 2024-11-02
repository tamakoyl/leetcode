package com.interview_experience.juc;

/**
 * @Author:Tamako
 * @Date:2024/8/9 22:11
 * @Description:TODO
 */
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

public class FairLock {
    private final AtomicReference<Thread> owner = new AtomicReference<>();
    private final Queue<Thread> waitingQueue = new ConcurrentLinkedQueue<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        waitingQueue.add(currentThread);

        // 自旋等待，直到当前线程成为队列头并且成功获取锁
        while (waitingQueue.peek() != currentThread || !owner.compareAndSet(null, currentThread)) {
            // 自旋
        }

        // 成功获取锁后，将当前线程从等待队列中移除
        waitingQueue.remove();
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();

        if (!owner.compareAndSet(currentThread, null)) {
            throw new IllegalMonitorStateException("Thread does not hold the lock");
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();

        // 创建多个线程来测试公平锁
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " attempting to acquire the lock");

            fairLock.lock();

            try {
                System.out.println(threadName + " acquired the lock");
                // 模拟持有锁一段时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(threadName + " releasing the lock");
                fairLock.unlock();
            }
        };

        // 启动多个线程
        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
