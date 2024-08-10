package org.example.lee.题目.动态规划;

public class b_乘积最大子数组 {
  
  public int maxProduct(int[] nums) {
    // 初始化最大乘积，当前的最大乘积辅助变量，当前的最小乘积辅助变量
    double max = nums[0], maxHelp = nums[0], minHelp = nums[0];

    // 遍历数组：从第二个元素开始
    for (int i = 1; i < nums.length; i++) {
        double value = nums[i]; 
        double aS = maxHelp, iS = minHelp;  
        //对于每个元素，我们需要考虑三种情况：
        //-直接取当前元素 value（如果maxHelp和minHelp都是负数时,value为正数,则取正数(负数效果毅然)）。
        //-当前元素乘以之前的最大乘积 maxHelp。
        //-当前元素乘以之前的最小乘积 minHelp（尤其是在当前元素为负数的情况下，这一步可能会使最小值变为最大值）。
        maxHelp = Math.max(Math.max(value, iS * value), aS * value);
        minHelp = Math.min(Math.min(value, aS * value), iS * value);

        // 更新全局最大乘积
        max = Math.max(max, maxHelp);
    }

    // 返回全局最大乘积，转为整数类型
    return (int) max;
}

}
