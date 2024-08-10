package org.example.lee.题目.双指针;

public class c_寻找两个正序数组的中位数 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int left = (nums1.length + nums2.length + 1) / 2, right = (nums1.length + nums2.length + 2) / 2;
    return (float) (findKth(nums1, nums2, 0, 0, left) + findKth(nums1, nums2, 0, 0, right)) / 2;
  }

  public int findKth(int[] nums1, int[] nums2, int index1, int index2, int k) {
    if (index1 >= nums1.length) {
      return nums2[index2 + k - 1];
    }
    if (index2 >= nums2.length) {
      return nums1[index1 + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[index1], nums2[index2]);
    }
    int mid1 = index1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[index1 + k / 2 - 1];
    int mid2 = index2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[index2 + k / 2 - 1];
    if (mid1 > mid2) {
      return findKth(nums1, nums2, index1 + k / 2, index2, k - k / 2);
    } else {
      return findKth(nums1, nums2, index1, index2 + k / 2, k - k / 2);
    }
  }
}
