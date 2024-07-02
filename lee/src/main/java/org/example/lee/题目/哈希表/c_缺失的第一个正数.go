package 哈希表

// 示例 1：
// 输入：nums = [1,2,0]
// 输出：3
// 解释：范围 [1,2] 中的数字都在数组中。
// 示例 2：
// 输入：nums = [3,4,-1,1]
// 输出：2
// 解释：1 在数组中，但 2 没有。
// 思路
// 因为要找的是数组中没有出现的最小正整数
// 所以这个数不会大于数组的长度 即 len
// 将位于0到数组长度间的元素放到它对应的下标
// 如[2,5,7]  就把2和5交换,2放在所需的下标1里
// 遍历执行后 最后再遍历数组 只要对应i下标的元素不等于i+1 就一定是最小正整数
func firstMissingPositive(nums []int) int {
	for i := 0; i < len(nums); i++ {
		//注意判断条件来避免死循环-> i != nums[i]-1 && nums[nums[i]-1] != nums[i]
		for nums[i] > 0 && nums[i] < len(nums) && i != nums[i]-1 && nums[nums[i]-1] != nums[i] {
			//注意交换顺序 如果是先nums[i]的话nums[i]-1就要注意保存一个数值
			//因为nums[i]中途就改变了
			//b := nums[i]-1
			//a := nums[i]
			//nums[i] = nums[b]
			//nums[b] = a
			a := nums[nums[i]-1]
			nums[nums[i]-1] = nums[i]
			nums[i] = a
		}
	}
	for i := 0; i < len(nums); i++ {
		if nums[i] != i+1 {
			return i + 1
		}
	}
	return len(nums) + 1
}
