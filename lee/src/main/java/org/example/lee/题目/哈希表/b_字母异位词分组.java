package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class b_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        //map用于存储排序后的字符串
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] array = str.toCharArray();
            //获得排序好的str
            Arrays.sort(array);
            String string = new String(array);
            List<String> aDefault = map.getOrDefault(string, new ArrayList<>());
            aDefault.add(str);
            //填进去
            map.put(string,aDefault);
        }
        return new ArrayList<>(map.values());
    }
}
