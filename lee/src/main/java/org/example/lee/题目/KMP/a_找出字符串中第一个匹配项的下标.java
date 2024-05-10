package org.example.lee.题目.KMP;

public class a_找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        int i = strStr("aabaabaafa", "aabaaf");
        System.out.println(i);
    }

    public static int[] getNext(String s){
        int j = -1;
        int[] next =new int[s.length()];
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            //前缀和后缀都是从左往右看
            // i=1时 串为 a i=2时 aa 1 i=3时aab 0 i=4时 aaba  i=5时 aabaa 2 i=6时 aabaaf 0
            while (j>=0 && s.charAt(j+1) != s.charAt(i)){
                j = next[j];
            }

            if(s.charAt(j+1) == s.charAt(i)){
                j++;
            }

            next[i] = j;
        }
        return next;
    }
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>=0 && haystack.charAt(i)!=needle.charAt(j+1)){
               j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == needle.length()-1){
                return i-needle.length();
            }
        }
        return -1;
    }
    public int strStrOld(String haystack, String needle) {

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
