package org.example.lee.题目.哈希表;

import java.util.HashMap;

public class a_同构字符串 {


    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map1 = new HashMap<>();
        Character c,d,e;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);d = t.charAt(i);e = map.getOrDefault(c,null);
            if(e==null){
                if(map1.containsKey(d)){
                    return false;
                }
                map.put(c,d);
                map1.put(d,c);
            }else {
                if(e.charValue()!=d.charValue()){
                    return false;
                }
            }
        }
        return true;

    }
}
