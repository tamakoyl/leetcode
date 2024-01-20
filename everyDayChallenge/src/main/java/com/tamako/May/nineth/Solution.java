package com.tamako.May.nineth;

import java.util.ArrayList;

/**
 * @Author:Tamako
 * @Date:2023/4/10 00:20
 * @Description: 1019. 链表中的下一个更大节点
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(2,new ListNode(1,new ListNode(5)));
        int[] res = new Solution().nextLargerNodes(head);
        for (int r : res) {
            System.out.println(r);
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = head;
        ListNode p;
        int bigger;
        while (cur!= null) {
            bigger = cur.val;
            p = cur.next;
            while (p != null) {
                //找到下一个较大的节点，直接break
                if (p.val > bigger) {
                    bigger = p.val;
                    break;
                }
                //否则继续向后寻找
                p = p.next;
            }
            //如果当前节点的值为bigger，说明没有比它更大的节点，所以返回0
            if (cur.val == bigger) {
                res.add(0);
                //否则返回bigger
            } else {
                res.add(bigger);
            }
            cur = cur.next;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
