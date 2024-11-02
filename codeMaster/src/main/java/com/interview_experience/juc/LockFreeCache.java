package com.interview_experience.juc;

/**
 * @Author:Tamako
 * @Date:2024/8/30 10:56
 * @Description:请设计一套线程安全缓存类用于缓存配置信息，该类
 * 需要能够支持缓存內任意起始地址任意长度(不超过
 *缓存)内存数据的高性能读写操作，请给出一种高效
 * 的实现方式；注意是在读多写少的场景，不使用读写锁
 */
import java.util.concurrent.atomic.AtomicReferenceArray;

public class LockFreeCache {
    private final AtomicReferenceArray<byte[]> cache;

    // 构造函数，初始化缓存大小
    public LockFreeCache(int size) {
        this.cache = new AtomicReferenceArray<>(size);
    }

    // 读取缓存中的数据
    public byte[] read(int index) {
        // 从缓存中获取数据
        return cache.get(index);
    }

    // 写入数据到缓存
    public void write(int index, byte[] data) {
        // 将数据写入缓存
        cache.set(index, data);
    }

    // 仅在index未被写入时才写入数据，利用CAS操作
    public boolean writeIfAbsent(int index, byte[] data) {
        return cache.compareAndSet(index, null, data);
    }

    // 清空缓存中的某个位置
    public void clear(int index) {
        cache.set(index, null);
    }

    // 获取缓存的大小
    public int size() {
        return cache.length();
    }
}

