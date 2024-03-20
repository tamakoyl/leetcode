package com.tamako.backtracking.hard.sudo;


/**
 * @Author:Tamako
 * @Date:2024/3/1 09:20
 * @Description:37. 解数独
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    //需要知道数独是否有解
    //todo backtracking 需要返回boolean
    // char 循环
    // 整个题的逻辑
    private boolean backtracking(char[][] board) {
        //  不需要递归终止条件
        //遍历board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if(backtracking(board)){//递归
                                return true;
                            }
                            board[i][j] = '.';//回溯
                        }
                    }
                    return false;//9个数都试完了
                }
            }
        }
        return true;//没有遇到false，棋盘也填完了
    }


    private boolean isValid(char[][] board, int row, int col, char num) {
        //同行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        //同列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        //同九宫格
        int col9 = col / 3, row9 = row / 3;
        for (int i = row9 * 3; i < row9 * 3 + 3; i++) {
            for (int j = col9 * 3; j < col9 * 3 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
