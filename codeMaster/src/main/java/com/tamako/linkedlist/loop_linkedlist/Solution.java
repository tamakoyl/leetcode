package com.tamako.linkedlist.loop_linkedlist;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/22 09:40
 * @Description: 142. 环形链表 II
 */
public class Solution {
    // O(n)Hash
    //todo  快慢指针 数学推导
    //(1) 判断成环
    //(2) 找到环形的入口点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index2!=index1){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
