package org.example.lee.题目.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class b_课程表2 {


        public  int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] arr = new int[numCourses];
            int[] res = new int[numCourses];
            int[] help = new int[numCourses];
            int index = numCourses - 1;
            Queue<int[]> queue = new LinkedList<>();
            for (int[] ar : prerequisites) {
                arr[ar[1]]++;
                queue.add(ar);
            }
            for (int i = 0; i < numCourses; i++) {
                if (arr[i] == 0) {
                    res[index--] =i;
                }
            }
            while (!queue.isEmpty()) {
                //本质上一次队列就是找一次环，然后在通过安全课程减一后重新找环 直到没环
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    if (arr[poll[0]] == 0) {
                        arr[poll[1]]--;
                        if (arr[poll[1]] == 0){
                            if (help[poll[1]]==0) {
                                res[index--] =poll[1];
                                help[poll[1]]=1;

                            }
                        }
                    } else {
                        queue.add(poll);
                    }
                }
                if (size == queue.size()) {
                    return new int[0];
                }
            }
            return res;
        }

}
