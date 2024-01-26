package org.example.lee.题目.其它;

public class a_最长公共前缀 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * longest common prefix
     * boring
     *
     * @param strs strs
     * @return {@link String}
     */
    public String longestCommonPrefix(String[] strs) {
        int over = 0, len = strs[0].length();
        Character a;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < len; i++) {
            a = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != a) {
                    return answer.toString();
                }
            }
            answer.append(a);
        }
        return answer.toString();
    }
}
