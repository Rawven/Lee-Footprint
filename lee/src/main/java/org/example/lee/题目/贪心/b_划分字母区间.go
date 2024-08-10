package 贪心

func partitionLabels(s string) []int {
	var awe []int
	arr, help, help1 := make([]int, 26), 0, 0
	for k, v := range s {
		arr[v-'a'] = k
	}
	for k, v := range s {
		help1 = max(help1, arr[v-'a'])
		help++
		if k == help1 {
			awe = append(awe, help)
			help = 0
		}
	}
	return awe
}
