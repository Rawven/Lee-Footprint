package 栈

func dailyTemperatures(temperatures []int) []int {
	n := len(temperatures)
	result := make([]int, n)
	stack := make([]int, 0, n) // 初始容量设置为 n
	for i := n - 1; i >= 0; i-- {
		for len(stack) > 0 && temperatures[stack[len(stack)-1]] <= temperatures[i] {
			//弹出温度小于当前日子的元素
			stack = stack[:len(stack)-1]
		}
		// 如果栈为空，说明没有更热的日子
		if len(stack) > 0 {
			result[i] = stack[len(stack)-1] - i
		}
		// 将当前索引压入栈中
		stack = append(stack, i)
	}
	return result
}
