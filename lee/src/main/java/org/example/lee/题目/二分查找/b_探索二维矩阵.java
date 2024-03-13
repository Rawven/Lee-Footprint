package org.example.lee.题目.二分查找;

public class b_探索二维矩阵 {

    public  boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int len = matrix.length * matrix[0].length;
        int i;
        int left = 0, right = len;
        while (left<right){
            i = (left+right)/2;
            int value = tool(matrix,i);
            if(value==target){
                return true;
            }
            if(i == left || i==right){
                return false;
            }
            if(value>target){
                right = i;
            }else {
                left = i;
            }
        }
        return false;
    }
    public  int tool(int[][] matrix,int value){
        int b = matrix[0].length;
        int i = value/b;
        int j = value%b;
        return matrix[i][j];
    }
}
