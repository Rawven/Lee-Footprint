package 二分查找

import "math"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// left 与 right 是为了处理 偶数元素下的中位数问题 （left + right）/2
	left, right := (len(nums1)+len(nums2)+1)/2, (len(nums1)+len(nums2)+2)/2
	return float64(findKth(nums1, nums2, 0, 0, left)+findKth(nums1, nums2, 0, 0, right)) / 2
}

func findKth(nums1, nums2 []int, index1, index2, k int) int {
	//已经超过数组长度 直接pass
	if index1 >= len(nums1) {
		return nums2[index2+k-1]
	}
	if index2 >= len(nums2) {
		return nums1[index1+k-1]
	}
	//k为1,恰好符合 取min
	if k == 1 {
		return min(nums1[index1], nums2[index2])
	}
	mid1, mid2 := math.MaxInt64, math.MaxInt64
	//二分查找 找k/2的位置
	if index1+k/2-1 < len(nums1) {
		mid1 = nums1[index1+k/2-1]
	}
	if index2+k/2-1 < len(nums2) {
		mid2 = nums2[index2+k/2-1]
	}
	//两个数组里较小的 mid 直接舍弃
	if mid1 < mid2 {
		return findKth(nums1, nums2, index1+k/2, index2, k-k/2)
	} else {
		return findKth(nums1, nums2, index1, index2+k/2, k-k/2)
	}
}
