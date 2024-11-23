package lee

import "sort"

func groupAnagrams(strs []string) [][]string {
	//m := map[[26]int][]string{}
	//for _, str := range strs {
	//	arr := []byte(str)
	//	help := [26]int{}
	//	for _, v := range arr {
	//		help[v-'a']++
	//	}
	//	m[help] = append(m[help], str)
	//}
	//res := [][]string{}
	//for _, v := range m {
	//	res = append(res, v)
	//}
	//return res
	m := map[string][]string{}
	for _, str := range strs {
		arr := []byte(str)
		sort.Slice(arr,
			func(i, j int) bool {
				return arr[i] < arr[j]
			})
		key := string(arr)
		m[key] = append(m[key], str)
	}
	res := [][]string{}
	for _, v := range m {
		res = append(res, v)
	}
	return res
}
