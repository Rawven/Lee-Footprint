package org.example.lee.题目.矩阵;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int a=0,i=0,j=0;
        while(list.size()<m*n){
         i=a;j=a;
         for (j = a; j < n-a; j++) {
             list.add(matrix[i][j]);
         }
         j--;
         for (i++; i < m-a;i++){
             list.add(matrix[i][j]);
         }
         i--;
         if(list.size()>=m*n){
             return list;
         }
         for (j-- ; j > a; j--) {
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