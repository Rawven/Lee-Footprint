package org.example.lee.题目.贪心;

public class b_盛最多水的容器 {


    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，
     * 第i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * max area
     *贪心算法 找局部最优解 关键：移动高板一定变小 要去找这个关键点
     * @param height height
     * @return int
     */
    public static int maxArea(int[] height) {
        int len = height.length, left=0,right = len-1,max=right*Math.min(height[left],height[right]);
        while (left<right) {
            if(height[left]>height[right]){
                right--;
            }else {
                left++;
            }
            max = Math.max((right-left)*Math.min(height[left],height[right]),max);
        }
        return max;
    }
}
