package com.tamako.nov.twentynine;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2023/11/29 10:08
 * @Description:2336. 无限集中的最小数字
 */
public class SmallestInfiniteSet {
//    private HashSet<Integer> positiveIntegerList;
//
//    public SmallestInfiniteSet() {
//        positiveIntegerList = new HashSet<>();
//        for (int i = 1; i <= 1000; i++) {
//            positiveIntegerList.add(i);
//        }
//    }
//
//    public int popSmallest() {
//        List<Integer> collect = positiveIntegerList.stream().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        }).collect(Collectors.toList());
//        positiveIntegerList.remove(collect.get(0));
//        return collect.get(0);
//    }
//
//    public void addBack(int num) {
//        positiveIntegerList.add(num);
//    }

    private Queue<Integer> infiniteQueue;
    private HashSet<Integer> infiniteHashSet;

    public SmallestInfiniteSet() {
        infiniteHashSet = new HashSet<>();
        infiniteQueue = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            infiniteQueue.offer(i);
            infiniteHashSet.add(i);
        }
    }

    public int popSmallest() {
        Integer smallest = infiniteQueue.poll();
        infiniteHashSet.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if(!infiniteHashSet.contains(num)){
            infiniteQueue.offer(num);
            infiniteHashSet.add(num);
        }
    }
}
