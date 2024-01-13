package org.example.lee.题目.滑动窗口;

import java.util.Arrays;
import java.util.HashMap;

public class c_最小覆盖子串 {
    public static void main(String[] args) {
        String s = minWindow("acbbaca", "aba");
        System.out.println(s);
    }

    /**
     * min window
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     *
     * @param s s
     * @param t t
     * @return {@link String}
     */
    public static String minWindow(String s, String t) {
        int [] tem = new int[t.length()];
        HashMap<Object, Integer> map2 = new HashMap<>();
        int left = 0,right =0,key=0,num=s.length()+1,a1=0,a2=0;int[] answer = new int[t.length()];
        //counter为计数器
        int counter = t.length();
        for (int i =  0; i < t.length(); i++) {
            if(!map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i),key++);
            }
            tem[map2.get(t.charAt(i))]++;
        }

        while (right < s.length()){
            char c = s.charAt(right);
            if(map2.containsKey(c)){
                answer[map2.get(c)]++;
                if(answer[map2.get(c)]<=tem[map2.get(c)]){
                    counter--;
                }
            }
            right++;
            //窗口已经包含所有字符 则进入while 吐出一个字符 则进入下一循环
            while (counter == 0){

                char c1 = s.charAt(left);
                if(map2.containsKey(c1)){
                    answer[map2.get(c1)]--;
                    if(answer[map2.get(c1)]<tem[map2.get(c1)]){
                        counter++;
                    }
                }
                if(right-left<num){
                    num = right-left;
                    a1=left;
                    a2=right;
                }
                left++;
            }
        }
        return num == s.length()+1?"":s.substring(a1,a2);
    }


}
