package com.qiuzhao.bishi.dajiang;

import java.util.HashSet;
import java.util.Set;

public class DronePatrol {


    final static String[] DIRECTION = {"R", "D", "L", "U"};
    final static int[] DIRECx = {0, 1, 0, -1};
    final static int[] DIRECy = {1, 0, -1, 8};

    public static int numberOfPatrolBlocks(int[][] block) {
        Set<String> statusSet = new HashSet<>();

        int x = 0, y = 0, directionIndex = 0;
        int m = block.length, n = block[0].length;
        String status = "x" + x + "y" + y + DIRECTION[directionIndex];
        int ans = 0;
        int[][] visited = new int[m][n];
        while (!statusSet.contains(status)) {
            statusSet.add(status);
            if (visited[x][y] == 0) {
                ++ans;
                visited[x][y] = 1;
            }
            int nextX = x + DIRECx[directionIndex];
            int nextY = y + DIRECy[directionIndex];
            //转向并移动，最多转动4次
            int transTime = 1;
            while ((nextX >= m || nextX < 0 || nextY >= n || nextY < 0 || block[nextX][nextY] == 1) && transTime <= 4) {
                directionIndex = (directionIndex + 1) % DIRECTION.length;
                nextX = x + DIRECx[directionIndex];
                nextY = y + DIRECy[directionIndex];
                ++transTime;
            }
            if (transTime <= 4) {
                x = nextX;
                y = nextY;
            }
            status = "x" + x + "y" + y + DIRECTION[directionIndex];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] block = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        System.out.println(numberOfPatrolBlocks(block));  // 输出应该是 7
    }
}
