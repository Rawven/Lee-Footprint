package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class b_字母异位词分组 {
    /**
     * group anagrams
     *  和单个判断字母异位词思想不同 因为是多个 先排序/
     * @param strs strs
     * @return {@link List}<{@link List}<{@link String}>>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        char[] c;String a;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            c = str.toCharArray();
            Arrays.sort(c);
            a = String.valueOf(c);
            List<String> list = map.get(a);
            if (list!=null) {
                list.add(str);
                map.put(a, list);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(a, l);
            }
        }
        return new ArrayList<>(map.values());
    }

}
