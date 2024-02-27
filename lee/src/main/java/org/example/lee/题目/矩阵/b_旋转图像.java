package org.example.lee.题目.矩阵;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.example.lee.util.LeeUtil;

import static org.example.lee.util.LeeUtil.printArray;

public class b_旋转图像 {
    public static void main(String[] args) {
        String str = "[[2,29,20,26,16,28],[12,27,9,25,13,21],[32,33,32,2,28,14],[13,14,32,27,22,26],[33,1,20,7,21,7],[4,24,1,6,32,34]]";
        String str1 = "[[4,33,13,32,12,2],[24,1,14,33,27,29],[1,20,32,32,9,20],[6,7,32,2,25,26],[32,21,22,28,13,16],[34,7,26,14,21,28]]";
        String str2 = "[[4,33,13,32,12,2],[24,1,14,33,27,29],[1,20,32,32,9,20],[6,7,27,2,25,26],[32,21,22,28,13,16],[34,7,26,14,21,28]]";
        printArray(str);
        System.out.println("\n");
        printArray(str1);
        System.out.println("\n");
        printArray(str2);
        rotate(LeeUtil.getArray(str));
    }


    public static void rotate(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        int m = matrix.length,n = matrix[0].length,num=0;
        int a=0,i,j;
        while(num<m*n){
            for (i =a,j = a; j < n-a-1; j++) {
                queue.add(matrix[i][j]);
            }
            for (; i < m-a;i++){
                num++;
                queue.add(matrix[i][j]);
                matrix[i][j] = queue.poll();
            }
            for (i--,j--; j >=a; j--) {
                num++;
                queue.add(matrix[i][j]);
                matrix[i][j] = queue.poll();
            }
            for (i--,j++; i >=a;i--){
                num++;
                queue.add(matrix[i][j]);
                matrix[i][j] = queue.poll();
            }
            for (i++,j++; j <n-a-1; j++) {
                num++;
                matrix[i][j] = queue.poll();
            }
            queue.poll();
            a++;
        }

    }
}
