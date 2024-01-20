package com.tamako.May.twelve;

/**
 * @Author:Tamako
 * @Date:2023/4/12 11:04
 * @Description: 1147. 段式回文
 */
public class Solution {
    public static void main(String[] args) {
        int res = new Solution().longestDecomposition("elvtoelvto");
        System.out.println(res);
    }

    public int longestDecomposition(String text) {
        char[] textArray = text.toCharArray();
        int length = textArray.length;
        int leftL = 0, leftR = 0;
        //初始化 rightL=1 为了进循环
        int rightL = 1, rightR = 0;
        int leftScan = 0, rightScan = 0;
        //记录匹配pattern的个数
        int count = 0;
        while (leftR < rightL) {
            rightL = length - 1 - leftR;
            rightR = length - 1 - leftL;
            leftScan = leftL;
            rightScan = rightL;
            //一个pattern进行匹配
            while (leftScan <= leftR && rightScan <= rightR && leftScan <= rightScan) {
                if (textArray[leftScan] == textArray[rightScan]) {
                    leftScan++;
                    rightScan++;
                } else {
                    break;
                }
            }
            //leftL != rightL  针对特例  "aaa"
            //匹配上
            if (leftScan - 1 == leftR && rightScan - 1 == rightR && leftL != rightL) {
                //匹配上的pattern数加一
                count++;
                //中间已经没有可以匹配的字符了
                if (leftR + 1 == rightL)break;
                //开始匹配下一个pattern
                leftL = leftR + 1;
                leftR += 1;
            } else {
                //没有匹配上pattern长度+1
                leftR++;
            }
        }

        //中间没有孤儿
        if (leftR + 1 == rightL) {
            return count * 2;
        }
        //中间有孤儿
        return count * 2 + 1;
    }
}
