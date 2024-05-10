package org.example.lee.题目.矩阵;

import org.example.lee.util.LeeUtil;

public class b_螺旋矩阵Ⅱ {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int num = 1,max = n*n,j = 0;
        while (num<=max){
            for (int i = j; i < n; i++) {
                arr[j][i]=num++;
            }
            for (int i = j+1; i < n; i++) {
                arr[i][n-1]=num++;
            }
            for (int i = n-2; i >= j; i--) {
                arr[n-1][i]=num++;
            }
            for (int i = n-2; i >= j+1; i--) {
                arr[i][j]=num++;
            }
            j++;
            n--;
        }
        return arr;
    }
}
