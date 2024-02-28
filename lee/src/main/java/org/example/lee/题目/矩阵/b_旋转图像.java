package org.example.lee.题目.矩阵;

import java.util.LinkedList;
import java.util.Queue;

public class b_旋转图像 {
    public void rotate(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        int m = matrix.length,n = matrix[0].length,num=0;
        int a=0,i=0,j=0;
        while(num<m*n){
         i=a;j=a;
         for (j = a; j < n-a; j++) {
             num++;
             queue.add(matrix[i][j]);
         }
         j--;
         for (i++; i < m-a;i++){
            num++;
             queue.add(matrix[i][j]);
             matrix[i][j] = queue.poll();
         }
         i--;
          if(num>=m*n){
              return ;
          }
         for (j-- ; j >=a; j--) {
            num++;
            queue.add(matrix[i][j]);
            matrix[i][j] = queue.poll();
         }
         for (; i >a;i--){
            num++;
            queue.add(matrix[i][j]);
            matrix[i][j] = queue.poll();
         }
         a++;
        }

    }
}
