package org.example.lee.题目.other;

public class a_回文数 {
    public static void main(String[] args) {
        isPalindrome(121);
    }

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * is palindrome
     * 无聊的题
     * @param x x
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        int array[] = new int[10];
        int right,left=0;
        if(x>=0){
            for ( right = 0; x!=0;right++){
                array[right]=x%10;
                x/=10;
            }
            right--;
            while (left<right){
                 if(array[left++]!=array[right--]){
                     return false;
                 }
            }
            return true;
        }
        return false;
    }
}
