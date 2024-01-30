package org.example.lee.题目.双指针;

public class a_验证回文串 {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        int left = 0 ,right = s.length()-1;
        char a,b;
        while (left<right){
            a=0;b=0;
            while (left<=right){
                if((s.charAt(left)>='a'&&s.charAt(left)<='z')
                    ||
                    (s.charAt(left)>='0'&&s.charAt(left)<='9')){
                    a = s.charAt(left);
                    left++;
                    break;
                }else if(s.charAt(left)>='A'&&s.charAt(left)<='Z'){
                    a = (char) (s.charAt(left)+32);
                    left++;
                    break;
                }
                left++;
            }
            while (left<=right){
                if((s.charAt(right)>='a'&&s.charAt(right)<='z') ||
                    (s.charAt(right)>='0'&&s.charAt(right)<='9')){
                    b = s.charAt(right);
                    right--;
                    break;
                }else if(s.charAt(right)>='A'&&s.charAt(right)<='Z'){
                    b = (char) (s.charAt(right)+32);
                    right--;
                    break;
                }
                right--;
            }
            if(left -1 == right){
                return a == b || b==0;
            }
            if(a!=b){
                return false;
            }

        }
        return true;
    }
}
