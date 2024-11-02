package com.interview_experience.data_structure;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author:Tamako
 * @Date:2024/8/10 18:46
 * @Description:TODO
 */
public class Tree {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(7);
        treeSet.add(4);
        for (Integer i : treeSet) {
            System.out.println(i);
        }
    }
}
