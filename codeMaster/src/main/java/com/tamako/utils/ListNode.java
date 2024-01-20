package com.tamako.utils;

/**
 * @Author:Tamako
 * @Date:2023/12/19 17:35
 * @Description:链表结点
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

     public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
