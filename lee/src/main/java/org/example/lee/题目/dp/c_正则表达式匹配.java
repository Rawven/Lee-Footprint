package org.example.lee.题目.dp;

public class c_正则表达式匹配 {
    /**
     * is match
     * TODO 非常好dp 使我的大脑成屎
     *  1.状态定义 dp[i][j]代表 s的前i与p的前j是否匹配
     *  2. 状态转移方程
     *   1.if(p[j] = *)  1. f[i-1][j] or f[i][j-2] s[i] = p[j-1]
     *                   2. f[i][j-2]              s[i]!= p[j-1]
     *   2.if(p[j] != *) 1. f[i−1][j−1]         s[i] = p[j]
     *                   2. false
     * @param s s
     * @param p p
     * @return boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
