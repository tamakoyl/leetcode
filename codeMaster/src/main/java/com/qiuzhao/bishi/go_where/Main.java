package com.qiuzhao.bishi.go_where;

/**
 * @Author:Tamako
 * @Date:2024/9/6 20:13
 * @Description:TODO
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 读取输入
        int n = Integer.parseInt(reader.readLine());
        String[] arr = reader.readLine().split(" ");

        // 自定义排序，比较拼接结果的字典序
        Arrays.sort(arr, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s1.compareTo(s2);
        });

        // 输出排序后的数组
        for (int i = 0; i < n; i++) {
            writer.write(arr[i]);
            if (i < n - 1) {
                writer.write(" ");
            }
        }
        writer.newLine();
        writer.flush();
    }
}
