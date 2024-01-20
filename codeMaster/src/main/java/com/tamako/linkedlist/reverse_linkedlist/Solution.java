package com.tamako.linkedlist.reverse_linkedlist;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/19 23:11
 * @Description:206. 反转链表
 */
public class Solution {
    //way1:头插法
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
        }
        return dummyHead.next;
    }

    //todo way2：递归
    public ListNode reverseList2(ListNode head) {
//        return reverse(null, head);
        return null;
    }

    public void reverse(ListNode pre, ListNode cur) {
        //递归出口
        if (cur == null) {
            return;
        }
        reverse(cur, cur.next);
        //需要进行的操作
        cur.next = pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;

        new Solution().reverse(null,head);
    }
}
