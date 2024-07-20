package 回溯

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	m := make(map[byte][]byte)
	m['2'] = []byte{'a', 'b', 'c'}
	m['3'] = []byte{'d', 'e', 'f'}
	m['4'] = []byte{'g', 'h', 'i'}
	m['5'] = []byte{'j', 'k', 'l'}
	m['6'] = []byte{'m', 'n', 'o'}
	m['7'] = []byte{'p', 'q', 'r', 's'}
	m['8'] = []byte{'t', 'u', 'v'}
	m['9'] = []byte{'w', 'x', 'y', 'z'}
	strs := &[]string{}
	var s []byte
	letterTool(s, m, strs, digits, 0)
	return *strs
}

func letterTool(str []byte, m map[byte][]byte, strs *[]string, digits string, index int) {
	if len(str) == len(digits) {
		*strs = append(*strs, string(str))
		return
	}
	u := digits[index]
	arr := m[u]
	for _, v := range arr {
		str = append(str, v)
		letterTool(str, m, strs, digits, index+1)
		str = str[:len(str)-1]
	}
}
