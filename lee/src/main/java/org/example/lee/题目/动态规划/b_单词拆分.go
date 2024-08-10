package dp

func wordBreak(s string, wordDict []string) bool {
	m := make(map[string]bool)
	for _, v := range wordDict {
		m[v] = true
	}
	dp := make([]bool, len(s)+1)
	dp[0] = true
	for i := 0; i < len(s); i++ {
		for j := 0; j <= i; j++ {
			if _, ok := m[s[j:i+1]]; dp[j] && ok {
				dp[i+1] = true
			}
		}
	}
	return dp[len(s)]
}
