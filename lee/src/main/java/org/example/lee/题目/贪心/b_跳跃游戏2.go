package 贪心

func jump(nums []int) int {
	var awe, i, save, mAX int
	for mAX < len(nums)-1 {
		for i <= save {
			if i+nums[i] > mAX {
				mAX = i + nums[i]
			}
			i++
		}
		save = mAX
		awe++
	}
	return awe
}
