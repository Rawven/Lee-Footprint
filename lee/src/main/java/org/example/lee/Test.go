package main

import (
	_ "container/list"
)

func QS(arr []int, left, right int) {
	if left < right {
		mid := partition(arr, left, right)
		QS(arr, left, mid-1)
		QS(arr, mid+1, right)
	}
}
func partition(arr []int, left, right int) int {
	save := left
	for left < right {
		for left < right && arr[save] <= arr[right] {
			right--
		}
		for left < right && arr[save] >= arr[left] {
			left++
		}
		arr[left], arr[right] = arr[right], arr[left]
	}
	arr[save], arr[right] = arr[right], arr[save]
	return right
}
func main() {
	arr := []int{7, 5, 8, 9, 1, 4, 5, 7, 5}
	QS(arr, 0, len(arr)-1)
	for _, v := range arr {
		print(v)
	}
}
