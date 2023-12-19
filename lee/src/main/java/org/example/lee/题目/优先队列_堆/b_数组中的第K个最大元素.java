package org.example.lee.题目.优先队列_堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class b_数组中的第K个最大元素 {


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
        heap heap = new heap();
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
    class heap {
        protected List<Integer> maxHeap = new ArrayList<>();
        /*堆的实现
         * “二叉树”章节讲过，完全二叉树非常适合用数组来表示。
         * 由于堆正是一种完全二叉树，因此我们将采用数组来存储堆。
         * 当使用数组表示二叉树时，元素代表节点值，
         * 索引代表节点在二叉树中的位置。节点指针通过索引映射公式来实现。
         * 如图 8-2 所示，给定索引
         *  ，其左子节点索引为2i+1
         *  ，右子节点索引为 2i+2
         *  ，父节点索引为(i-1)/2
         * （向下整除）。当索引越界时，表示空节点或节点不存在。
         */

        private int left (int i ){
            return 2*i+1;
        }

        private int right (int i ){
            return 2*i+2;
        }
        private int parent(int i){
            return (i-1)/2;
        }
        private void swap (int i ,int j){
            int t = maxHeap.get(i);
            maxHeap.set(i,maxHeap.get(j));
            maxHeap.set(j,t);
        }
        public Integer peek(){
            return maxHeap.get(0);
        }

        void  offer(int i){
            maxHeap.add(i);
            siftUp(maxHeap.size()-1);
        }

        private void siftUp(int i){
            while (true){
                // 获取节点i 的父节点
                int p = parent(i);
                if(p<0 || maxHeap.get(i)<=maxHeap.get(p)){
                    break;
                }
                swap(i,p);
                i = p ;
            }
        }

        public int poll(){
            if(maxHeap.isEmpty()){
                throw new RuntimeException("dd");
            }
            // 交换根节点与最右叶节点（交换首元素与尾元素）
            swap(0, maxHeap.size() - 1);
            // 删除节点
            int val = maxHeap.remove(maxHeap.size() - 1);
            // 从顶至底堆化
            siftDown(0);
            // 返回堆顶元素
            return val;
        }
        /* 从节点 i 开始，从顶至底堆化 */
        private void siftDown(int i) {
            while (true) {
                int l = left(i), r = right(i), ma = i;
                // 判断节点 i, l, r 中值最大的节点，记为 ma
                if (l < maxHeap.size() && maxHeap.get(l) > maxHeap.get(ma)) {
                    ma = l;
                }
                if (r < maxHeap.size() && maxHeap.get(r) > maxHeap.get(ma)) {
                    ma = r;
                }
                // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
                if (ma == i) {
                    break;
                }
                // 交换两节点
                swap(i, ma);
                // 循环向下堆化
                i = ma;
            }
        }
    }
}
