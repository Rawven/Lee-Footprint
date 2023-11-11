public class 寻找两个正序数组的中位数 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出并返回这两个正序数组的 中位数 。
     * find median sorted arrays
     * 双指针 复杂度为m+n
     * @param nums1 nums1
     * @param nums2 nums2
     * @return double
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //记录长度
        int s1 = nums1.length, s2 = nums2.length;
        //i 对应数组1下标 j 对应数组2下标
        int total = nums2.length + nums1.length, i = 0, j = 0, count = 0;
        //b1用来收集偶数情况下的前一个值 b2则作为奇数情况下的值和偶数情况下的后一个值
        int b1 = 0, b2 = 0;
        //TODO 既遍历n/2+1次
        // 奇数情况下n/2+1次则直接找到对应值（既 （n+1）/2）
        // 偶数情况下 则n/2+1次找到中位数右边的值 然后b1又保留了前边的值
        while (count <= total / 2) {
            b1=b2;
            //TODO 简单理解
            // 当i没越界且 j越界了或者i的对应的值小于j对应的值就只动i 其他情况动j
            if(i<=s1-1&&(j>s2-1||nums1[i]<nums2[j])) {
                b2=nums1[i];
                i++;
            }else {
                b2=nums2[j];
                j++;
            }
            count++;
        }
        //判断一下奇偶
        if (total % 2 == 0) {
            return (double) (b1 + b2) / 2;
        }
        return b2;
    }
}
