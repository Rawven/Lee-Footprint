package 其它

// 思路 每个不同元素互相抵消 一定是超过一半的元素留下
func majorityElement(nums []int) int {
	var awe, help int
	for _, num := range nums {
		if help == 0 {
			awe = num
		}
		if awe == num {
			help++
		} else {
			help--
		}
	}
	return awe
}
