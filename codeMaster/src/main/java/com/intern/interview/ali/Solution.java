package com.intern.interview.ali;

public class Solution {
    public static void main(String[] args) {
        String num1 = new String("111");
        String num2 = new String("999");
        String sum = addBigInteger(num1, num2);
        System.out.println(sum);
    }

    private static String addBigInteger(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 < len2) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            len1 = num1.length();
            len2 = num2.length();
        }

        int array = 0;
        int j = len2 - 1;

        for (int i = len1 - 1; i >= 0; i--) {
            int sum = num1.charAt(i) - '0' + (j >= 0 ? num2.charAt(j) - '0' : 0) + array;
            result.append(sum % 10);
            array = sum / 10;
            j--;
        }
        if (array > 0) {
            result.append(array);
        }
        return result.reverse().toString();
    }
}
