package com.tamako.dp.bag.complete.word_break;

import java.util.HashSet;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/3/12 12:12
 * @Description:139. 单词拆分
 */
public class Solution {
    //todo 回溯


    // todo 回溯+记忆化





    //dp
    // todo 关于对物品的抽象:这个题的物品就是s的子串了！！！就是需要判断一下这个子串在不在wordDict里面，然后再考虑放不放
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = false;
        }
        dp[0] = true;//起源为true
        // 需要有顺序：排列
        // 先遍历容量，再遍历物品
        for (int i = 1; i <= n; i++) {//遍历背包
            for (int j = 0; j < i; j++) {//遍历物品 todo j  <  i
                String substring = s.substring(j, i);
                if (dp[j] && wordSet.contains(substring)) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
