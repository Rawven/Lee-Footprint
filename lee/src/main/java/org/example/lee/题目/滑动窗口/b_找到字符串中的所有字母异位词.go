package hdck

func findAnagrams(s string, p string) []int {
	var arr, brr [26]int
	var result []int
	if len(p) > len(s) {
		return result
	}

	for i := 0; i < len(p); i++ {
		arr[s[i]-'a']++
		brr[p[i]-'a']++
	}
	if arr == brr {
		result = append(result, 0)
	}

	for i := len(p); i < len(s); i++ {
		arr[s[i]-'a']++
		arr[s[i-len(p)]-'a']--
		if arr == brr {
			result = append(result, i-len(p)+1)
		}
	}
	return result
}
