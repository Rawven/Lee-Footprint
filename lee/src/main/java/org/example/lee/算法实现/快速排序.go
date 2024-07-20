package 算法实现

func QS(arr []int, left, right int) {

	mid := partition(arr, left, right)
	QS(arr, left, mid-1)
	QS(arr, mid+1, right)
}
func partition(arr []int, left, right int) int {
	med := arr[left]
	for left < right {
		for left < right && med <= arr[right] {
			right--
		}
		for left < right && med >= arr[left] {
			left++
		}
		arr[left], arr[right] = arr[right], arr[left]
	}
	med, arr[right] = arr[right], med
	return right
}
