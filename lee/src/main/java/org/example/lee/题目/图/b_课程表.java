package org.example.lee.题目.图;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class b_课程表 {

    /**
     * can finish
     * 拓扑排序
     * @param numCourses    num courses
     * @param prerequisites prerequisites
     * @return boolean
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        Queue<int[]> queue = new LinkedList<>();
        for(int[] ar : prerequisites){
            arr[ar[1]]++;
            queue.add(ar);
        }
        while (!queue.isEmpty()){
            //本质上一次队列就是找一次环，然后在通过安全课程减一后重新找环 直到没环
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if(arr[poll[0]]==0){
                    arr[poll[1]]--;
                }else {
                    queue.add(poll);
                }
            }
            if(size == queue.size()){
                return false;
            }
        }
        return true;
    }
}
