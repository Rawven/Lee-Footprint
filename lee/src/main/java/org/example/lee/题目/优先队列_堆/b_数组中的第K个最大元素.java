package org.example.lee.题目.优先队列_堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class b_数组中的第K个最大元素 {
    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 20);
    }

    /**
     * find kth largest
     *  利用快排的划分思想
     * @param nums nums
     * @param k    k
     * @return int
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int i =0,j = len-1;
        while (true) {
            int key = partition(nums, i, j);
            if (key == len - k) {
                return nums[key];
            }else if (key > len - k) {
                j = key - 1;
                //跳过重复的元素
                while (j > len - k && nums[j] == nums[j+1]) {
                    j--;
                }
            } else {
                i = key + 1;
                while (len - k > i && nums[i] == nums[i-1]) {
                    i++;
                }
            }
        }
    }

    static int medianThree(int[] nums, int left, int mid, int right) {
        // 此处使用异或运算来简化代码
        // 异或规则为 0 ^ 0 = 1 ^ 1 = 0, 0 ^ 1 = 1 ^ 0 = 1
        if ((nums[left] < nums[mid]) ^ (nums[left] < nums[right])) {
            return left;
        } else if ((nums[mid] < nums[left]) ^ (nums[mid] < nums[right])) {
            return mid;
        } else {
            return right;
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int med = medianThree(nums, left, (left + right) / 2, right);
        int t = nums[med];
        nums[med] = nums[left];
        nums[left] = t;
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        t = nums[i];
        nums[i] = nums[left];
        nums[left] = t;
        return i;
    }


    /**
     * find kth largest1
     * 优先队列法 面试可能不给调库函数
     *
     * @param nums nums
     * @param k    k
     * @return int
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(value -> value));
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() != null && heap.peek() < nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}
