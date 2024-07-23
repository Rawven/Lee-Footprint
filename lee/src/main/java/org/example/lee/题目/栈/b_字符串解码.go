package 栈

import "strings"

func decodeString(s string) string {
	var arr strings.Builder
	var counter int
	for i := 0; i < len(s); i++ {
		v := s[i]
		//只处理 数字 字母 [ 三种情况
		if isNumber(v) {
			counter = counter*10 + int(v-'0')
		} else if isDigest(v) {
			arr.WriteByte(v)
		} else if v == '[' {
			fast, save := i, 0
			//找到这轮'['字符对应的']'字符
			for fast < len(s) {
				if s[fast] == '[' {
					save++
				} else if s[fast] == ']' {
					save--
					if save == 0 {
						break
					}
				}
				fast++
			}
			//嵌套的情况通过递归处理
			//fast的结束状态为']' 然后s[i+1 : fast]只会拿到 (i+1) - (fast-1)
			s2 := decodeString(s[i+1 : fast])
			arr.WriteString(strings.Repeat(s2, counter))
			//完成当前这轮的[]，重置counter和i
			//后面还有个i++,所以先保持为fast即可
			i = fast
			counter = 0
		}
	}
	return arr.String()
}

func isNumber(v byte) bool {
	return v >= '0' && v <= '9'
}
func isDigest(v byte) bool {
	return (v >= 'a' && v <= 'z') ||
		(v >= 'A' && v <= 'Z')
}
