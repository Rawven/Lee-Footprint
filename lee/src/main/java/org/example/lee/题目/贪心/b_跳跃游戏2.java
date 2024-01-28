package org.example.lee.题目.贪心;

public class b_跳跃游戏2 {

    /**
     * jump
     * 贪心即可 只走最远的
     * @param nums nums
     * @return int
     */
    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int max = nums[0],status = max,i=1,time =0;
        while(i < nums.length&&status<nums.length-1) {
            while(i<=status) {
                if (max < i + nums[i]) {
                    max = i + nums[i];
                }
                i++;
            }
            status = max;
            time++;
        }
        return ++time;
    }
}
