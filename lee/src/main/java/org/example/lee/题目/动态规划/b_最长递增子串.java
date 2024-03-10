package org.example.lee.题目.动态规划;

public class b_最长递增子串 {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    /**
     * length of lis
     *
     * @param nums nums
     * @return int
     */
    public static int lengthOfLIS(int[] nums) {
        //tails[i]记录当前子串的最小后缀
        int[] tails = new int[nums.length];
        int size = 0;
        /**
        * 如 nums= [10,9,2,5,3,7,101,18], 当k=6时,
         *  tails[0]=2(k=时为10,后为9，2),tails[1]=3(在k=3时为2,k=4时更新为3),tails[2]=7(在)
        */
        for (int num : nums) {
            int left = 0, right = size;
            while (left != right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == size) {
                ++size;
            }
        }
        return size;
    }



    /**
     * length of lis
     * 简单dp 时间复杂度n^2
     * @param nums nums
     * @return int
     */
    public  int lengthOfLIS1(int[] nums) {

        int[] dp = new int[nums.length];
        int max=1;
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
