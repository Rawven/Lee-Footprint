public class c_接雨水 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * trap
     * 双指针 贪心 重在分析会发生的情况 来找突破点
     * TODO 是第一个自己做出来的hard题 加油💪
     * @param height height
     * @return int
     */
    public static int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1, total = 0, i,z;
        while (left < right) {
            //TODO 永远操作矮柱 因为高的柱子可能是最高柱 但矮柱绝对不是
            if (height[left] < height[right]) {
                for (i = left + 1; i <= right; i++) {
                    //TODO 遍历 找比它更高或相同柱子 然后接雨水
                    if (height[left] <= height[i]) {
                        //TODO 遍历来接雨水
                        for (z = left + 1; z < i ; z++) {
                            total += height[left] - height[z];
                        }
                        //TODO 换柱 重新回到循环
                        left = i;
                        break;
                    }
                }
            } else {
                for (i = right - 1; left <= i; i--) {
                    if (height[right] <= height[i]) {
                        for (z = right - 1; z > i ; z--) {
                            total += height[right] - height[z];
                        }
                        right = i;
                        break;
                    }
                }
            }
        }
        return total;
    }


}
