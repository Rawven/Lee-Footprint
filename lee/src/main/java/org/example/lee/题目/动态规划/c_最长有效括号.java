package org.example.lee.题目.动态规划;

/**
 * c 最长有效括号
 *
 * @author 刘家辉
 * @date 2023/11/18
 */
public class c_最长有效括号 {


    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * longest valid parentheses
     * 动态规划
     * TODO     思路：动态规划
     *     1. 状态定义：动态规划[i]表示以s[i]结尾的最长有效括号子串的长度
     *     2. 状态转移方程：
     *       1. s[i] == '('，动态规划[i] = 0
     *       2. s[i] == ')'，s[i-1] == '('，动态规划[i] = 动态规划[i-2](边界: i-2>=0) + 2
     *       3. s[i] == ')'，s[i-1] == ')'，s[i-动态规划[i-1]-1](边界: i-动态规划[i-1]-1>=0) == '('，动态规划[i] = 动态规划[i-1] + 2 + 动态规划[i-动态规划[i-1]-2](边界: i-动态规划[i-1]-2>=0)
     *     3. 初始状态：动态规划[0] = 0
     *     4. 返回值：max(动态规划[i])
     *
     * @param s s
     * @return int
     */
    public int longestValidParentheses(String s) {
        int max = 0, len = s.length();
        int dp[] = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
