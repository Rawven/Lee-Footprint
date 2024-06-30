package zfc

func rotate(nums []int, k int) {
	k = k % len(nums)
	reverse(nums, 0, len(nums))
	reverse(nums, 0, k)
	reverse(nums, k, len(nums))
}

func reverse(nums []int, i, j int) {
	j--
	for i < j {
		a := nums[i]
		nums[i] = nums[j]
		nums[j] = a
		i++
		j--
	}
}
