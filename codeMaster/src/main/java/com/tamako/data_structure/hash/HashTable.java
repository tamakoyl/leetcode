package com.tamako.data_structure.hash;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/4/1 21:17
 * @Description:自己实现的hashTable，使用拉链法来解决冲突
 */
public class HashTable {
    private int size;
    private List<LinkedList<Integer>> table;
    private double loadFactor;
    private int free;

    public HashTable(int size, double loadFactor) {
        this.size = size;
        this.loadFactor = loadFactor;
        this.free = size;

        // 初始化每个数组元素
        table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    private boolean add(int val) {
        if (has(val)) {
            return false;
        }
        int pos = val % size;
        if (table.get(pos).isEmpty()) {
            free--;
        }
        table.get(pos).addFirst(val); // 在链表头部添加元素
        if ((size - free) > size * loadFactor) {
            // 扩容
            expand();
        }
        return true;
    }

    private boolean has(int val) {
        int pos = val % size;
        LinkedList<Integer> conflictLinkList = table.get(pos);
        for (Integer integer : conflictLinkList) {
            if (integer == val) {
                return true;
            }
        }
        return false;
    }

    private boolean remove(int val) {
        if (!has(val)) {
            return false;
        }
        int pos = val % size;
        LinkedList<Integer> conflictLinkList = table.get(pos);
        for (int i = 0; i < conflictLinkList.size(); i++) {
            if (conflictLinkList.get(i) == val) {
                conflictLinkList.remove(i);
                if (conflictLinkList.size() == 0) {
                    free++;
                }
                break;
            }
        }
        if (free > size * loadFactor) {
            shrink();
        }
        return true;
    }

    private void shrink() {
        List<LinkedList<Integer>> newTable = new ArrayList<>(size / 2);
        // 初始化每个数组元素
        for (int i = 0; i < size / 2; i++) {
            newTable.add(new LinkedList<>());
        }
        free = size / 2;
        for (LinkedList<Integer> list : table) {
            for (Integer val : list) {
                int pos = val % (size / 2);
                if (newTable.get(pos).isEmpty()) {
                    free--;
                }
                newTable.get(pos).addFirst(val);
            }
        }
        size /= 2;
        table = newTable;
        free = size;
    }

    private void expand() {
        List<LinkedList<Integer>> newTable = new ArrayList<>(size * 2);
        // 初始化每个数组元素
        for (int i = 0; i < size * 2; i++) {
            newTable.add(new LinkedList<>());
        }
        free = size * 2;
        for (LinkedList<Integer> list : table) {
            for (Integer val : list) {
                int pos = val % (size * 2);
                if (newTable.get(pos).isEmpty()) {
                    free--;
                }
                newTable.get(pos).addFirst(val);
            }
        }
        size *= 2;
        table = newTable;
    }


    public static void main(String[] args) {
//        HashTable hashTable = new HashTable(8, 0.75);
//        hashTable.add(5);
//        hashTable.add(6);
//        hashTable.add(7);
//        hashTable.add(8);
//        hashTable.add(10);
//        hashTable.add(13);
//        hashTable.add(12);
//        hashTable.add(11);
//        hashTable.add(17);
//        hashTable.add(18);
//        boolean has = hashTable.has(5);
//        hashTable.remove(13);
//        hashTable.remove(12);
//        hashTable.remove(11);
//        hashTable.add(17);
//        hashTable.add(18);
        HashTable hashTable = new HashTable(10, 0.75);

        // 测试缩容功能
        System.out.println("\n测试缩容功能：");
        for (int i = 0; i < 7; i++) {
            hashTable.add(i); // 添加元素使得负载因子超过阈值
        }
        System.out.println("当前容量：" + hashTable.size); // 应该输出 10
        System.out.println("扩前 free：" + hashTable.free); // 应该输出 3
        hashTable.add(7);
        System.out.println("扩容后 free：" + hashTable.free); // 应该输出 12
        System.out.println("缩容后容量：" + hashTable.size); // 应该输出 20

        // 添加元素并测试添加功能
        System.out.println("添加元素测试：");
        System.out.println("添加 5：" + hashTable.add(5)); // 应该返回 true
        System.out.println("添加 15：" + hashTable.add(15)); // 应该返回 true
        System.out.println("添加 25：" + hashTable.add(25)); // 应该返回 true
        System.out.println("添加 5（重复）：" + hashTable.add(5)); // 应该返回 false

        // 查找元素并测试查找功能
        System.out.println("\n查找元素测试：");
        System.out.println("是否存在 5：" + hashTable.has(5)); // 应该返回 true
        System.out.println("是否存在 10：" + hashTable.has(10)); // 应该返回 false

        // 删除元素并测试删除功能
        System.out.println("\n删除元素测试：");
        System.out.println("删除 5：" + hashTable.remove(5)); // 应该返回 true
        System.out.println("是否存在 5：" + hashTable.has(5)); // 应该返回 false
        System.out.println("删除 10（不存在）：" + hashTable.remove(10)); // 应该返回 false
    }

}
