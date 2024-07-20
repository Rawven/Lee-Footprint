package 图

import "container/list"

// slice重写版本
func canFinish(numCourses int, prerequisites [][]int) bool {
	l := make([][]int, 0, numCourses)
	arr := make([]int, numCourses)
	for _, v := range prerequisites {
		arr[v[1]]++
		l = append(l, v)
	}
	for len(l) > 0 {
		nl := make([][]int, 0, numCourses)
		for _, v := range l {
			ar := v
			if arr[ar[0]] == 0 {
				arr[ar[1]]--
			} else {
				nl = append(nl, ar)
			}
		}
		if len(l) == len(nl) {
			return false
		}
		l = nl
	}
	return true
}

// list性能很差,用slice重写一下就好
func canFinish1(numCourses int, prerequisites [][]int) bool {
	l := list.New()
	arr := make([]int, numCourses)
	for _, v := range prerequisites {
		arr[v[1]]++
		l.PushFront(v)
	}
	for l.Len() > 0 {
		length := l.Len()
		for i := 0; i < length; i++ {
			ar := l.Front().Value.([]int)
			l.Remove(l.Front())
			if arr[ar[0]] == 0 {
				arr[ar[1]]--
			} else {
				l.PushBack(ar)
			}
		}
		if length == l.Len() {
			return false
		}
	}
	return true
}
