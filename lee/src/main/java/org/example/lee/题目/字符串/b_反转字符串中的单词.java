package org.example.lee.题目.字符串;

public class b_反转字符串中的单词 {
    public static void main(String[] args) {
        reverseWords("  hello world  ");
    }

    /**
     * reverse words
     * 除空格连单词即可
     * @param s s
     * @return {@link String}
     */
    public static String reverseWords(String s) {
        int index,len = s.length(),right;
        index = len-1;
        StringBuilder stringBuilder = new StringBuilder();
        while (index>=0) {
            while (index >=0 && s.charAt(index) == ' ') {
                index--;
            }
            if(index<0){
                break;
            }
            right = index+1;
            while (index >=0 && s.charAt(index) != ' ') {
                index--;
            }
            stringBuilder.append(s,index<0?0:index+1,right).append(' ');
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
