package 位运算

func singleNumber(nums []int) int {
	var awe int
	for _, num := range nums {
		awe ^= num
	}
	return awe
}
