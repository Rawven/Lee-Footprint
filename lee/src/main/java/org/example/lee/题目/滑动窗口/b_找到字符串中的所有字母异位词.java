package org.example.lee.题目.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_找到字符串中的所有字母异位词 {


    /**
     * find anagrams
     * 滑动窗口教学
     *
     * @param s s
     * @param p p
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        int left = 0, right = p.length() - 1;
        int[] arrayP = new int[26];
        int[] arrayS = new int[26];
        for (int i = 0; i < plen; i++) {
            arrayP[p.charAt(i) - 'a']++;
            arrayS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arrayS, arrayP)) {
            list.add(0);
        }

        for (int i = 0; i < slen - plen; i++) {
            --arrayS[s.charAt(i) - 'a'];
            ++arrayS[s.charAt(i + plen) - 'a'];
            if (Arrays.equals(arrayS, arrayP)) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
