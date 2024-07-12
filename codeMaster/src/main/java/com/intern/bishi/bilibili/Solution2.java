package com.intern.bishi.bilibili;

import java.util.Scanner;

/**
 * @Author:Tamako
 * @Date:2024/4/28 19:47
 * @Description:翻转指定区间的字符串
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        char[] sArray = s.toCharArray();
        //前[k,n]正序
        String res = s.substring(k-1,n);
//        System.out.println(new String(sArray));
        if (n % 2 == 0) {
            //后半段是逆序
            reverse(sArray, 0, n - 1);
            String reversStr = new String(sArray);
            res+=reversStr.substring(n-k,n);
        }else {
            //后半段是正序
            res+= s.substring(0,k);
        }
        System.out.println(res);
    }


    public static void reverse(char[] strArray, int start, int end) {
        while (start < end) {
            char tmp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = tmp;
            start++;
            end--;
        }
    }

}
