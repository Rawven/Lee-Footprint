package hdck

// 0ms做法
func minWindow(s string, t string) string {
	//因为ascii固定 所以直接128固定数组
	var aArr, bArr [128]int
	//counter为所需字符的最小数量
	left, minLen, counter, key := 0, len(s)+1, len(t), ""
	//aArr作为t内字符的统计数组
	for i := 0; i < len(t); i++ {
		aArr[t[i]]++
	}
	//bArr作为s内窗口的统计数组
	for right := 0; right < len(s); right++ {
		//该字符存在于t中
		if aArr[s[right]] > 0 {
			r := s[right]
			//如果小于所需数量
			if bArr[r] < aArr[r] {
				counter--
			}
			bArr[r]++
		}
		//当所需的都已满足
		for counter == 0 {
			//取最小的字符串
			if right+1-left < minLen {
				key = s[left : right+1]
				minLen = right + 1 - left
			}
			if aArr[s[left]] > 0 {
				//当字符刚好够，退出目前的字符，然后counter+1,退出循环,寻找下一个符合的窗口
				if bArr[s[left]] == aArr[s[left]] {
					counter++
				}
				//当前窗口的对应字符-1
				bArr[s[left]]--
			}
			//慢指针右移
			left++
		}
	}
	return key
}

// 原先思路 22ms
func minWindow1(s string, t string) string {
	needArr, nowArr, m := make([]int, len(t)), make([]int, len(t)), make(map[byte]int)
	left, minLen, counter, key, help := 0, len(s)+1, len(t), "", 0
	for i := 0; i < len(t); i++ {
		c := t[i]
		if _, ok := m[c]; !ok {
			m[c] = help
			help++
		}
		needArr[m[c]]++
	}
	for right := 0; right < len(s); right++ {
		if _, ok := m[s[right]]; ok {
			r := m[s[right]]
			if nowArr[r] < needArr[r] {
				counter--
			}
			nowArr[r]++
		}
		for counter == 0 {
			if right+1-left < minLen {
				key = s[left : right+1]
				minLen = right + 1 - left
			}
			if _, ok := m[s[left]]; ok {
				l := m[s[left]]
				nowArr[l]--
				if nowArr[l] < needArr[l] {
					counter++
				}
			}
			left++
		}
	}
	return key
}
