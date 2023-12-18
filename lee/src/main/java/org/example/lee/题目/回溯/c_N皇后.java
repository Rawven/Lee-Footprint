package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.List;

public class c_N皇后 {

    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * solve nqueens
     * 回溯第一题 不是哥们 这真牛阿
     * @param n n
     * @return {@link List}<{@link List}<{@link String}>>
     */
    public static List<List<String>> solveNQueens(int n) {
        char[][] arrs = new char[n][n];
        List<List<String>> list = new ArrayList<>();
        for (char[] arr:
             arrs) {
            for (int i = 0; i < n; i++) {
                arr[i]='.';
            }
        }
        solutions(list,arrs,0,n);
        return list;
    }

    public static void solutions(List<List<String>> list, char[][] arr, int row, int n) {
        if (row == n) {
            ArrayList<String> strings = new ArrayList<>();
            for (char[] c : arr) {
                strings.add(new String(c));
            }
            list.add(strings);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(arr,i,row,n)) {
                arr[row][i]='Q';
                solutions(list,arr,row+1,n);
                arr[row][i]='.';
            }
        }
    }

    public static boolean isValid(char[][] arr,int columns,int row,int n) {
        for (int i = 0; i < row; i++) {
            if(arr[i][columns] == 'Q'){ return false;}
        }
        for (int a = row-1,b = columns-1; a >=0 && b>=0 ; a--,b--) {
             if(arr[a][b] == 'Q'){return false;}
        }
        for (int a = row-1,b=columns+1; a >=0&& b<n ;a--,b++) {
            if(arr[a][b] == 'Q'){return false;}
        }
        return true;
    }
}
