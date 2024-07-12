package com.intern.bishi.meituan.m_2024_4_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:Tamako
 * @Date:2024/4/13 19:41
 * @Description:TODO
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        long k = in.nextLong();
//        int[] nums = new int[n];
//        in.nextLine();//读取换行符
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        int res = getMostZero(nums, k);
//        System.out.println(res);
//    }
//
//    //贪心
//    public static int getMostZero(int[] nums, long k) {
//        //先转为正数
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Math.abs(nums[i]);
//        }
//        //排序
//        Arrays.sort(nums);
//        int i = 0;
//        while (k > 0) {
//            k -= nums[i++];
//        }
//        return k == 0 ? i : i - 1;
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();//读取换行符
//        for (int i = 0; i < n; i++) {
//            String code = in.nextLine();//读取货物编号
//            int score = calScore(code);
//            System.out.println(score);
//        }
//    }


//    public static int calScore(String code) {
//        int score = 0;
//        char[] codeCharArray = code.toCharArray();
//
//        //MMNN
//        if (codeCharArray[0] == codeCharArray[1] &&
//                codeCharArray[2] == codeCharArray[3] &&
//                codeCharArray[0] != codeCharArray[2]) {
//            score += 3;
//            //MNMN
//        } else if (codeCharArray[0] == codeCharArray[2] &&
//                codeCharArray[1] == codeCharArray[3] &&
//                codeCharArray[0] != codeCharArray[1]) {
//            score += 2;
//        }
//        //奇数/偶数
//        if ((codeCharArray[0] % 2 == 0 && codeCharArray[1] % 2 == 0 && codeCharArray[2] % 2 == 0 && codeCharArray[3] % 2 == 0) ||
//                (codeCharArray[0] % 2 == 1 && codeCharArray[1] % 2 == 1 && codeCharArray[2] % 2 == 1 && codeCharArray[3] % 2 == 1)) {
//            score += 2;
//        }
//
//        for (int i = 0; i < codeCharArray.length; i++) {
//            if (codeCharArray[i] == '3' || codeCharArray[i] == '6') {
//                score += 1;
//            }
//
//        }
//
//        if (isConsecutive(codeCharArray)) {
//            score += 10;
//        }
//
//        int sameCnt = 1;
//        for (int i = 1; i < codeCharArray.length; i++) {
//            if (codeCharArray[i] == codeCharArray[i - 1]) {
//                sameCnt++;
//            }
//        }
//        if (sameCnt == 4) {
//            score += 8;
//        } else if (sameCnt == 3) {
//            score += 3;
//        }
//        return score;
//    }
//
//
//    public static boolean isConsecutive(char[] digits) {
//        return digits[0] + 1 == digits[1] && digits[1] + 1 == digits[2] && digits[2] + 1 == digits[3] ||
//                digits[0] - 1 == digits[1] && digits[1] - 1 == digits[2] && digits[2] - 1 == digits[3];
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//节点数
        in.nextLine();//读取换行符
        String colorString = in.nextLine();
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colorString.charAt(i - 1) == 'B') {
                colors[i] = 1;//black
            } else if (colorString.charAt(i - 1) == 'R') {
                colors[i] = 0;
            }
        }

        //存边
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];

        cntSubTrees(graph,colors,1,visited);
        System.out.println(cnt);
    }


    private static int cnt = 0;

    private static int[] cntSubTrees(List<List<Integer>> graph, int[] colors, int node, boolean[] visited) {
        //递归出口:应该自动会退出呀！！！！！！
        visited[node] = true;
        int redCnt = colors[node] == 0 ? 1 : 0;
        int blackCnt = colors[node] == 1 ? 1 : 0;

        for (Integer child : graph.get(node)) {
            if (!visited[child]) {
                int[] childCnt = cntSubTrees(graph, colors, child, visited);
                redCnt += childCnt[0];
                blackCnt += childCnt[1];
            }
        }
        if (redCnt > 0 && blackCnt > 0) {
            cnt++;
        }
        return new int[]{redCnt, blackCnt};
    }
}
