package com.tamako.linkedlist.lru_cache;

import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2024/4/8 10:08
 * @Description:146. LRU 缓存
 */
public class LRUCache {
    //todo 超时了！！！
//    class Node {
//        private Node next;
//        private int key;
//        private int val;
//
//        public Node(int key, int val, Node next) {
//            this.key = key;
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    private int cap;
//    private Node head;
//
//    private int len;
//
//
//    public LRUCache(int capacity) {
//        this.cap = capacity;
//        this.head = new Node(-1, -1, null);
//        this.len = 0;
//    }
//
//    public int get(int key) {
//        Node p = head;
//        int cnt = 0;
//        while (cnt <= len) {
//            if (p.key == key) {
//                //get后需要把它插入到头
//                put(key, p.val);
//                return p.val;
//            }
//            p = p.next;
//            cnt++;
//        }
//        return -1;
//    }
//
//    public void delDup(int key) {
//        int cnt = 0;
//        Node p = head, pre = null;
//        while (cnt <= len) {
//            if (p.key == key && pre != null) {
//                pre.next = p.next;
//                len--;
//                return;
//            }
//            pre = p;
//            p = p.next;
//            cnt++;
//        }
//    }
//
//
//    //头插法
//    public void put(int key, int value) {
//        //cache区域需要维护唯一性
//        delDup(key);
//        head.next = new Node(key, value, head.next);
//        if (len < cap) {
//            len++;
//        }
//    }

    // todo 实现方法是: 循环双链表 +  Hash
    class Node {
        private Node next;

        private Node pre;
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int cap;
    private Node head,tail;

    private int len;

    //key:key
    private HashMap<Integer,Node> cache;


    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.cap = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
        len = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        //key在缓存中，移动到头部
        moveToHead(node);
        return node.val;
    }


    public void removeNode(Node node){
       node.pre.next = node.next;
       node.next.pre = node.pre;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    public void addToHead(Node node){
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    public Node removeTail(){
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    //头插法
    public void put(int key, int value) {
        //cache区域需要维护唯一性
        Node node = cache.get(key);
        if(node == null){
            Node p = new Node(key, value);
            addToHead(p);
            cache.put(key,p);
            len++;
            if(len > cap){
                Node lastNode = removeTail();
                cache.remove(lastNode.key);//删除缓存
                len--;
            }
        }else {
            //cache中存在
            node.val = value;//修改为最新的值
            moveToHead(node);
        }
    }



    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        int i = lruCache.get(4);
        int i1 = lruCache.get(3);
        int i2 = lruCache.get(2);
        int i3 = lruCache.get(1);
        lruCache.put(5, 5);
    }
}
