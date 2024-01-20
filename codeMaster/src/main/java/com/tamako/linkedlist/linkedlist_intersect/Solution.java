package com.tamako.linkedlist.linkedlist_intersect;

import com.tamako.utils.ListNode;

/**
 * @Author:Tamako
 * @Date:2023/12/20 23:27
 * @Description: 02.07. 链表相交
 */
public class Solution {
    //todo 求长度差
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB, firstMove, secondMove;
        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }

        if (lenA > lenB) {
            firstMove = headA;
            secondMove = headB;
        } else {
            firstMove = headB;
            secondMove = headA;
        }
        int step = Math.abs(lenA - lenB);
        while (step-- > 0) {
            firstMove = firstMove.next;
        }
        while (firstMove != null && secondMove != null) {
            if (firstMove == secondMove) {
                return firstMove;
            }
            firstMove = firstMove.next;
            secondMove = secondMove.next;
        }
        return null;
    }
}
