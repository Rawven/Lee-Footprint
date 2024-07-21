package 回溯

func partition(s string) [][]string {
	var awe [][]string
	var arr []string
	partitionTool(s, &awe, arr, 0)
	return awe
}

func partitionTool(s string, awe *[][]string, arr []string, start int) {
	if start == len(s) {
		temp := make([]string, len(arr))
		copy(temp, arr)
		*awe = append(*awe, temp)
		return
	}
	for i := start; i < len(s); i++ {
		if toolPartition(s, start, i) {
			arr = append(arr, s[start:i+1])
			partitionTool(s, awe, arr, i+1)
			arr = arr[:len(arr)-1]
		}
	}
}

func toolPartition(s string, start, end int) bool {
	for start < end {
		if s[start] != s[end] {
			return false
		}
		start++
		end--
	}
	return true
}
