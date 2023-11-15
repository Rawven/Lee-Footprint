package org.example.lee;

import java.util.HashMap;

public class a_罗马转整数 {

    /**
     * roman to int
     * most boring
     * @param s s
     * @return int
     */
    public int romanToInt(String s) {
        int len = s.length(),index=0,answer=0,a,b;
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);
        b=1000;
        while (index<len) {
            a = map.get(s.charAt(index));
            if(b<a){
                answer += a - 2*b;
            }else {
                answer += a;
            }
            index++;
            b=a;
        }
        return answer;
    }
}
