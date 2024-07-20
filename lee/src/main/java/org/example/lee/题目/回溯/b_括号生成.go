package 回溯

func generateParenthesis(n int) []string {
	awe := &[]string{}
	var arr []byte
	generateTool(n, n, arr, awe)
	return *awe
}

func generateTool(left, right int, arr []byte, awe *[]string) {
	if left == 0 && right == 0 {
		*awe = append(*awe, string(arr))
		return
	}
	if left > 0 && left <= right {
		generateTool(left-1, right, append(arr, '('), awe)
	}
	if left < right {
		generateTool(left, right-1, append(arr, ')'), awe)
	}
}
