package org.example.lee.题目.图;

import java.util.LinkedList;
import java.util.Queue;
import org.example.lee.util.LeeUtil;

public class b_蛇梯棋 {


    public  int snakesAndLadders(int[][] board) {
        if (board.length == 0) {
            return 0;
        }
        int index =1;
        int x = board.length, tool = 0, end = x * x;
        int[] arr = new int[end+1];
        // 转为一维数组 方便操作
        for (int i = x-1; i >=0; i--) {
            if (tool == 0) {
                tool = 1;
                for (int j = 0; j < x; j++) {
                    arr[index++] = board[i][j];
                }
            } else {
                tool = 0;
                for (int j = x-1; j >= 0 ; j--) {
                    arr[index++] = board[i][j];
                }
            }
        }
        //队列辅助存元素
        Queue<int[]> queue = new LinkedList<>();
        //判断来过没 来过就不用再入队 因为绝对是慢的了
        boolean[] view = new boolean[end + 1];
        // init
        queue.add(new int[] {1, 0});

        while (!queue.isEmpty()) {
            int[] i = queue.poll();
            //遍历 1 - 6
            for (int j = 1; j <= 6; j++) {
                int b = i[0] + j;
                //遇到蛇和梯子
                if (arr[b] > 0) {
                    b = arr[b];
                }
                //刚好到达
                if (b >= end) {
                    return i[1] + 1;
                }
                //访问过没
                if (!view[b]) {
                    view[b] = true;
                    queue.offer(new int[] {b, i[1] + 1});
                }

            }
        }
        return -1;
    }
}
