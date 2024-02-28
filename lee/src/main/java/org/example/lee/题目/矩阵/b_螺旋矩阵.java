package org.example.lee.题目.矩阵;

import java.util.ArrayList;
import java.util.List;


public class b_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int a=0,i=0,j=0;
        while(list.size()<m*n){
            for (i=a,j = a; j < n-a; j++) {
                list.add(matrix[i][j]);
            }
            for (i++,j--; i < m-a;i++){
                list.add(matrix[i][j]);
            }
            if(list.size()>=m*n){
                return list;
            }
            for (i--,j-- ; j > a; j--) {
                list.add(matrix[i][j]);
            }
            for (; i >a;i--){
                list.add(matrix[i][j]);
            }
            a++;
        }
        return list;
    }
}