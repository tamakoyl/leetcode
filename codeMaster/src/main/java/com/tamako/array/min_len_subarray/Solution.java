package com.tamako.array.min_len_subarray;

/**
 * @Author:Tamako
 * @Date:2023/4/22 00:02
 * @Description:209. 长度最小的子数组
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = new Solution().minSubArrayLen(7, nums);
        System.out.println(res);
    }

    //使用滑动窗口
    //window  from 1 - ..
    //自己的滑动窗口比较笨重，写成了tcp的滑动窗口
//    public int minSubArrayLen(int target, int[] nums) {
//        int sum = 0,initSum=0;
//        for (int windowSize = 1; windowSize <= nums.length; windowSize++) {
//            initSum+=nums[windowSize-1];
//            sum = initSum;
//            if (sum >= target) {
//                return windowSize;
//            }
//            for (int i = 0; i < nums.length - windowSize; i++) {
//                //向右边滑动
//                sum -= nums[i];
//                sum += nums[i + windowSize];
//                if (sum >= target) {
//                    return windowSize;
//                }
//            }
//        }
//        return 0;
//    }
    public int minSubArrayLen(int target, int[] nums) {
        //初始化 滑动窗口 左侧
        //初始求和
        //初始最短滑动窗口距离
        int windowLeft = 0, sum = 0, minLen = Integer.MAX_VALUE;
        //滑动窗口右侧需要初始化为-1
        for (int windowRight = -1; windowRight < nums.length; ) {
            //更新滑动窗口最小长度
            if (sum >= target) {
                if (windowRight - windowLeft+1 < minLen) {
                    minLen = windowRight - windowLeft+1;
                }
                //当前sum>target窗口左侧向前滑动
                sum -= nums[windowLeft++];
            } else {
                //由于初始化为-1，需要有一个边界判定条件
                if(windowRight == nums.length - 1)break;
                //当前sum<target，窗口右侧向右边滑动
                sum += nums[++windowRight];
            }
        }
        //如果minLen没有被更新，则代表找不到这样的子数组，返回0
        return minLen == Integer.MAX_VALUE ? 0:minLen;
    }
}
