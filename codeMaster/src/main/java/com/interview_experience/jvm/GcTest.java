package com.interview_experience.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tamako
 * @since 2024-8-10
 * -Xms41m -Xmx41m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 */
public class GcTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("0.---两次young gc");
        List caches = new ArrayList();
        for (int i = 0; i < 6; i++) {
            caches.add(new byte[3 * _1MB]);
        }
        System.out.println("1.---一次full");
        caches.add(new byte[10 * _1MB]);  // 大对象，可能会直接进入老年代
        caches.add(new byte[10 * _1MB]); //大对象，可能会直接进入老年代
        caches.clear();
        caches.add(new byte[6 * _1MB]); //大对象，可能会直接进入老年代
//        caches.clear();//清除掉引用,被full gc回收
//        caches.add(new byte[2*_1MB]);//再慢慢往eden填,eden内存紧张了，会尝试将对象晋升到老年代，此时老年代已经负载很高了，此时会触发full gc
        System.out.println("2.---两次young gc");
        for (int i = 0; i < 4 ; i++){
            caches.add(new byte[3 * _1MB]);
        }
    }
}
