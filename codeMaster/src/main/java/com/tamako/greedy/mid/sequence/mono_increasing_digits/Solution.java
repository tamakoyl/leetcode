package com.tamako.greedy.mid.sequence.mono_increasing_digits;


/**
 * @Author:Tamako
 * @Date:2024/3/6 10:02
 * @Description:738. 单调递增的数字
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String numStr = String.valueOf(n);
        char[] numCharArray = numStr.toCharArray();
        int flag = numStr.length();
        for (int i = numStr.length() - 1; i > 0; i--) {
            if (numCharArray[i - 1] > numCharArray[i]) {
                flag = i;//todo 后面的都要变为9
                numCharArray[i - 1]--;
            }
        }

        for (int i = flag; i < numStr.length(); i++) {
            numCharArray[i] = '9';
        }
        return Integer.parseInt(new String(numCharArray));
    }
}
