package hdck

import "container/list"

// 单调队列例题 单调队列：即按元素在队列里是按大小排序的
// 运用了双向链表 在go里这种速度较慢 在java里挺快的（笑哭）
func maxSlidingWindow(nums []int, k int) []int {
	//头元素为即为当前窗口最大值的下标
	l := list.New()
	var arr []int
	for i := 0; i < k; i++ {
		//a1:把尾部小的都移除，毕竟只有最大值会被用到
		for l.Len() != 0 && nums[l.Back().Value.(int)] < nums[i] {
			l.Remove(l.Back())
		}
		//放进尾部
		l.PushBack(i)
	}
	//先放入当前的最大值
	arr = append(arr, nums[l.Front().Value.(int)])
	for i := k; i < len(nums); i++ {
		//继续a1
		for l.Len() != 0 && nums[l.Back().Value.(int)] < nums[i] {
			l.Remove(l.Back())
		}
		l.PushBack(i)
		//把超出当前窗口的头部元素都移除
		for l.Front().Value.(int) <= i-k {
			l.Remove(l.Front())
		}
		//收集最大值
		arr = append(arr, nums[l.Front().Value.(int)])
	}
	return arr
}
