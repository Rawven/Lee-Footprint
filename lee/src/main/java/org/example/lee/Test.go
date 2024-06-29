package main

import _ "container/list"

func main() {
	minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")
}
func minWindow(s string, t string) string {
	needArr, nowArr := make([]int, len(t)), make([]int, len(t))
	m := make(map[byte]int)
	var help int
	for i := 0; i < len(t); i++ {
		if _, ok := m[t[i]]; !ok {
			m[t[i]] = help
			help++
		}
		needArr[m[t[i]]]++
	}
	left, minLen := 0, len(s)+1
	var key string
	for right := 0; right < len(s); right++ {
		if _, ok := m[s[right]]; ok {
			nowArr[m[s[right]]]++
		}
		for equal(needArr, nowArr, len(t)) {
			if right+1-left < minLen {
				key = s[left : right+1]
				minLen = right + 1 - left
			}
			if _, ok := m[s[left]]; ok {
				nowArr[m[s[left]]]--
			}
			left++
		}

	}
	return key
}
func equal(a []int, b []int, len int) bool {
	for i := 0; i < len; i++ {
		if a[i] > b[i] {
			return false
		}
	}
	return true
}
