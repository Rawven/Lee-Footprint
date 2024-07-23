package 栈

// 本质上是取以每一根柱为高，然后找到该柱的左右两边最远的距离来取面积
// 遍历每一根柱然后取最大值
// 通过单调栈来存储左右两边第一个比i柱矮的下标

// 有点迷的做法 算右边的下标会有问题
// 有点迷的做法 算右边的下标会有问题
func largestRectangleArea(heights []int) int {
	stack, leftHelp, rightHelp := make([]int, 0), make([]int, len(heights)), make([]int, len(heights))
	var mmax int
	//提前设置n
	for i := 0; i < len(heights); i++ {
		rightHelp[i] = len(heights)
	}
	for i := 0; i < len(heights); i++ {
		for len(stack) > 0 && heights[i] < heights[stack[len(stack)-1]] {
			//下标设置可能有问题 但是不影响结果
			rightHelp[stack[len(stack)-1]] = i
			stack = stack[:len(stack)-1]
		}
		if len(stack) != 0 {
			leftHelp[i] = stack[len(stack)-1]
		} else {
			//没找到即左边都比i柱高 直接上-1
			leftHelp[i] = -1
		}
		stack = append(stack, i)
	}
	//求解
	for i := 0; i < len(heights); i++ {
		mmax = max(mmax, (rightHelp[i]-leftHelp[i]-1)*heights[i])
	}
	return mmax
}

// 朴素做法
func largestRectangleArea1(heights []int) int {
	leftStack, rightStack, leftHelp, rightHelp := make([]int, 0), make([]int, 0), make([]int, len(heights)), make([]int, len(heights))
	var mmax int
	for i := 0; i < len(heights); i++ {
		for len(leftStack) != 0 && heights[leftStack[len(leftStack)-1]] >= heights[i] {
			leftStack = leftStack[:len(leftStack)-1]
		}
		//找到了左边第一个比i柱矮的位置
		if len(leftStack) != 0 {
			leftHelp[i] = leftStack[len(leftStack)-1]
		} else {
			//没找到即左边都比i柱高 直接上-1
			leftHelp[i] = -1
		}
		leftStack = append(leftStack, i)
	}
	//同理
	for i := len(heights) - 1; i >= 0; i-- {
		for len(rightStack) != 0 && heights[rightStack[len(rightStack)-1]] >= heights[i] {
			rightStack = rightStack[:len(rightStack)-1]
		}
		if len(rightStack) != 0 {
			rightHelp[i] = rightStack[len(rightStack)-1]
		} else {
			//没找到即左边都比i柱高 直接上n
			rightHelp[i] = len(heights)
		}
		rightStack = append(rightStack, i)
	}
	//求解
	for i := 0; i < len(heights); i++ {
		mmax = max(mmax, (rightHelp[i]-leftHelp[i]-1)*heights[i])
	}
	return mmax
}
