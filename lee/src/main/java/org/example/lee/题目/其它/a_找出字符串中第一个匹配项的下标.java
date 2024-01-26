package org.example.lee.题目.其它;

public class a_找出字符串中第一个匹配项的下标 {


    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                //TODO 不调用函数也很好实现 根据长度来一个个匹配就行
                // 不符合就从下一个匹配的字符开始新的一轮
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
