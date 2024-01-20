package com.tamako.linkedlist.del_last_n_node;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/20 23:12
 * @Description:19. 删除链表的倒数第 N 个结点
 */
public class Solution {
    //迭代
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = head,pre = dummyHead,cur = head;
        int len = 0;
        while (p!=null){
            p = p.next;
            len++;
        }

        int index = len - n;
        while (index-->0){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return dummyHead.next;
    }

    //递归 todo
}
