package hdck

func lengthOfLongestSubstring(s string) int {
	//时间复杂度为O(n),因为只有左右指针各遍历过一次（2*n）
	set := make(map[byte]bool)
	help, answer := -1, 0
	for i := 0; i < len(s); i++ {
		if i != 0 {
			delete(set, s[i-1])
		}
		for help+1 < len(s) && set[s[help+1]] != true {
			set[s[help+1]] = true
			help++
		}
		answer = max(answer, len(set))
	}
	return answer
}
