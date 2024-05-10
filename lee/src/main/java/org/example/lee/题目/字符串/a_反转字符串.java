package org.example.lee.题目.字符串;

public class a_反转字符串 {
    public void reverseString(char[] s) {
        int len = s.length;
        int left =0 ,right = len-1;
        char h;
        while (left<=right){
            h = s[left];
            s[left] = s[right];
            s[right] = h;
            left++;right--;
        }
    }
}
