package com.tamako.july;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2023/7/17 15:46
 * @Description:约瑟夫环
 */
public class JosephLoop {
    public static void main(String[] args) {
        int res = new JosephLoop().lastRemain(70866, 116922);
        System.out.println(res);
    }

    //模拟法会越界....
    int lastRemain(int n, int m) {
        if (m > n) {
            m = m % n;
        }
        boolean[] people = new boolean[n];
        int cnt = 0;
        int i = 0, j = 0;
        while (cnt < n - 1) {
            if (!people[j % n] && (i + 1) % m == 0) {
                cnt++;
                people[j % n] = true;
            }
            j++;
            if (!people[j % n]) {
                i++;
            }
        }
        int res = -1;
        for (int k = 0; k < n; k++) {
            if (!people[k]) {
                res = k;
            }
        }
        return res;
    }

}
