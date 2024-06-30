package qzh

// https://leetcode.cn/problems/product-of-array-except-self/solutions/11472/product-of-array-except-self-shang-san-jiao-xia-sa
// 不错的解析
// 画图表示一下就有想法了
func productExceptSelf(nums []int) []int {
	help := make([]int, len(nums))
	help[0] = 1
	//下三角
	//help[i-1]携带了上一次乘法计算的结果
	for i := 1; i < len(nums); i++ {
		help[i] = help[i-1] * nums[i-1]
	}
	//上三角
	//h起到的作用就是携带上一次乘法计算的结果
	h := 1
	for i := 1; i < len(nums); i++ {
		h *= nums[len(nums)-i]
		help[len(nums)-i-1] *= h
	}
	return help
}
