package org.example.lee.算法实现;

/**
 * 快速排序
 *
 * @author 刘家辉
 * @date 2023/12/18
 */
public class 快速排序 {

    /* 选取三个元素的中位数 */
    int medianThree(int[] nums, int left, int mid, int right) {
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

    /**
     * partition 划分
     *
     * @param nums  nums
     * @param left  left
     * @param right right
     * @return int
     */
    public int partition(int[] nums, int left, int right) {
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
        return i;
    }

    public void qS(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        qS(nums, left, pivot - 1);
        qS(nums, pivot + 1, right);
    }

}
