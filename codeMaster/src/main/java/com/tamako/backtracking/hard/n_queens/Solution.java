package com.tamako.backtracking.hard.n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/29 10:09
 * @Description:51. N 皇后
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard,0,n);
        return res;
    }

    private List<List<String>> res = new ArrayList<>();

    private void backtracking(char[][] chessboard, int row, int n) {
        //递归出口
        //当检查到第n行，就可以收集结果了
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if(isValid(chessboard,row,col,n)){
                chessboard[row][col] = 'Q';
                backtracking(chessboard, row+1, n);//递归下一行
                chessboard[row][col] = '.';//回溯 撤销皇后
            }
        }
    }

    // todo 因为每次是从一行中挑一个，所以同行不用检查
    private boolean isValid(char[][] chessboard, int row, int col, int n) {
        //检查同列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        //todo 检查斜对角45度和135度 因为下面的棋盘还没有往里面填
        //45
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        //135
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List Array2List(char[][] chessboard){
        ArrayList<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
           list.add(String.copyValueOf(c));
        }
        return list;
    }

}
