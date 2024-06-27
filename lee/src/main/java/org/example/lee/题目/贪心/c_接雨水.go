package 贪心

// 双指针做法
// 易懂版本
func trap(height []int) int {
	length := len(height)
	left, right, leftM, rightM, key := 0, length-1, 0, 0, 0
	for left < right {
		leftM = max(height[left], leftM)
		rightM = max(height[right], rightM)
		if leftM > rightM {
			key += rightM - height[right]
			right--
		} else {
			key += leftM - height[left]
			left++
		}
	}
	return key
}

// 双指针做法
// 官解版本
func trap2(height []int) int {
	length := len(height)
	left, right, leftM, rightM, key := 0, length-1, 0, 0, 0
	for left < right {
		leftM = max(height[left], leftM)
		rightM = max(height[right], rightM)
		if height[left] > height[right] {
			//为什么必有rightM<leftM? 因为只有矮柱才会移动
			//key += min(leftM, rightM) - height[right]
			key += rightM - height[right]
			right--
		} else {
			//key += min(leftM, rightM) - height[left]
			key += leftM - height[left]
			left++
		}
	}
	return key
}

// dp 做法
func trap1(height []int) int {
	length := len(height)
	leftMax := make([]int, length)
	rightMax := make([]int, length)
	//初始值
	leftMax[0] = height[0]
	rightMax[length-1] = height[length-1]
	for i := 1; i < length; i++ {
		leftMax[i] = max(leftMax[i-1], height[i])
	}
	for i := length - 2; i >= 0; i-- {
		rightMax[i] = max(rightMax[i+1], height[i])
	}
	key := 0
	for i := 0; i < length; i++ {
		//两边最低减自己的高度
		key += min(leftMax[i], rightMax[i]) - height[i]
	}
	return key
}
