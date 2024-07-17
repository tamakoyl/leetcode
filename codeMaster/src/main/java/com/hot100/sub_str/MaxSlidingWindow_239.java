package com.hot100.sub_str;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_239 {

    public static void main(String[] args) {
        // maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
        // maxSlidingWindow(new int[] { 1 }, 1);
        maxSlidingWindow(new int[] { 7, 2, 4 }, 2);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // 最后的答案长度是nums.length - k + 1
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // Remove elements not within the sliding window
            // 从队首元素 循环移除
            // 已经不在滑动窗口中了的元素
            // 滑动窗口元素的index范围[i-k+1,i]
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Maintain decreasing order in deque
            // 维持递减的特性
            // 队尾元素 >= 当前元素；
            // 循环移除队尾元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 加入到队尾
            deque.offerLast(i); // Store index into deque

            // Start recording max value when window has covered k elements
            // 每移动一次滑动窗口，记录一次队首元素
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
