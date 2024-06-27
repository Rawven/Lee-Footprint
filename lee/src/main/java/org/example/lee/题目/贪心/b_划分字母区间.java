package org.example.lee.题目.贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b_划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']=i;
        }
        int help = 0,num = 0;
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            help = Math.max(arr[s.charAt(i)-'a'],help);
            num++;
            if(help == i){
                list.add(num);
                num=0;
            }
        }
        return list;
    } public List<Integer> partitionLabels1(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }
        int help = 0,num = 0;
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            help = Math.max(map.get(s.charAt(i)),help);
            num++;
            if(help == i){
                list.add(num);
                num=0;
            }
        }
        return list;
    }
}
