package org.example.lee.题目.递归;

import java.util.ArrayList;
import java.util.List;

public class b_电话号码的组合 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * letter combinations
     * 最轻松的一题
     *
     * @param digits digits
     * @return {@link List}<{@link String}>
     */
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        tool(list, str, "", digits);
        return list;

    }

    public static void tool(List<String> list, String[] array, String str, String digits) {
        if (digits.isEmpty()) {
            list.add(str);
            return;
        }
        int index = digits.charAt(0) - 50;
        int i = 0;
        StringBuilder stringBuilder;
        String s = array[index];
        while (i < s.length()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(s.charAt(i));
            i++;
            tool(list, array, stringBuilder.toString(), digits.substring(1));
        }
    }
}
