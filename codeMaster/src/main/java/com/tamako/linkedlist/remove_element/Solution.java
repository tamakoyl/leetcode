package com.tamako.linkedlist.remove_element;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/19 11:51
 * @Description: 203. 移除链表元素
 */
public class Solution {
    //迭代法：模拟头节点 dummy_node
    //todo 移除元素的时候只需要cur往后移动
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;

        }
        return dummyHead.next;
    }
}
