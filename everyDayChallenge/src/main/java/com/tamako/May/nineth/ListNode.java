package com.tamako.May.nineth;

/**
 * @Author:Tamako
 * @Date:2023/4/10 00:22
 * @Description: 单链表节点
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
