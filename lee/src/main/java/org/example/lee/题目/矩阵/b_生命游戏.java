package org.example.lee.题目.矩阵;

import org.example.lee.util.LeeUtil;

public class b_生命游戏 {
    public static void main(String[] args) {
        gameOfLife(LeeUtil.getArray("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]"));
    }
        public static void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    check(board, i, j);
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j]/=10;
                }
            }
        }

         static void check(int[][] board,int i,int j) {
            int key = 0;
            if (i > 0) {
                key += board[i - 1][j] % 10;
            }
            if (j > 0) {
                key += board[i][j - 1] % 10;
            }
            if (i < board.length - 1) {
                key += board[i + 1][j] % 10;
            }
            if (j < board[0].length - 1) {
                key += board[i][j + 1] % 10;
            }
            if(i>0){
                if(j>0){
                    key += board[i - 1][j - 1] % 10;
                }
                if(j<board[0].length-1){
                    key += board[i - 1][j + 1] % 10;
                }
            }else {
                if(j>0){
                    key += board[i + 1][j - 1] % 10;
                }
                if(j<board[0].length-1){
                    key += board[i + 1][j + 1] % 10;
                }
            }
            if (board[i][j] == 1) {
                if (key >= 2 && key <= 3) {
                    board[i][j] += 10;
                }
            } else {
                if (key == 3) {
                    board[i][j] += 10;
                }
            }
        }
}
