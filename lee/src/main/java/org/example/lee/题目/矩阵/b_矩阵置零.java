package org.example.lee.题目.矩阵;

public class b_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;boolean rowz=false,cowz=false;
        for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if(matrix[i][j]==0){
                   if(i==0){
                       rowz=true;
                   }
                    if(j==0){
                       cowz=true;
                   }
                  matrix[0][j]=0;
                  matrix[i][0]=0;
               }
           }
        }
        for (int i = 1; i < m; i++) {
               for (int j = 1; j < n; j++) {
                   if(matrix[0][j]==0 || matrix[i][0]==0){
                   matrix[i][j]=0;
                   }
               }
        }
        if(rowz){
            for(int j =0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(cowz){
            for(int i =0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
