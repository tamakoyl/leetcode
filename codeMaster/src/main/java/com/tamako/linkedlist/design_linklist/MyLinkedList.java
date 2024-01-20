package com.tamako.linkedlist.design_linklist;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/19 19:21
 * @Description:设计链表
 */
public class MyLinkedList {
    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = new ListNode(-1);
        size = 0;
    }

    //todo 考虑非法值
    public int get(int index) {
        if (index >= size) return -1;
        ListNode p = head;
        while (index-- >= 0) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        ListNode p = new ListNode(val);
        p.next = head.next;
        head.next = p;
        size++;
    }

    public void addAtTail(int val) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        //末尾是可以添加元素的
        if (index > size) return;
        ListNode pre = head, p = head.next;
        while (index-- > 0) {
            pre = p;
            p = p.next;
        }
        ListNode k = new ListNode(val);
        pre.next = k;
        k.next = p;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        ListNode pre = head, p = head.next;
        while (index-- > 0) {
            pre = p;
            p = p.next;
        }
        pre.next = p.next;
        size--;
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3,0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5,0);
        myLinkedList.addAtHead(6);





//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1,2);
//        myLinkedList.get(1);
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.get(1);
    }
}
