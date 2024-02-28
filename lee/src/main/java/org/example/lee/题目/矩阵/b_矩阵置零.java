package org.example.lee.题目.矩阵;

import org.example.lee.util.LeeUtil;

public class b_矩阵置零 {

    public static void main(String[] args) {
        int[][] array = LeeUtil.getArray("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        setZeroes(array);
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=0;
                    if(j<m&&i<n){
                        matrix[j][i]=0;
                    }
                }
            }
        }
    }
}
