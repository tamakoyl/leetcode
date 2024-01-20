package com.tamako.linkedlist.swap_nodes;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/19 23:13
 * @Description:24. 两两交换链表中的节点
 */
public class Solution {
    //迭代
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        //todo 注意 break 循环条件
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = pre.next;
        }
        return dummyHead.next;
    }
    //todo 递归

}
