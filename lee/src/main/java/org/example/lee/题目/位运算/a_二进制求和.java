package org.example.lee.题目.位运算;

public class a_二进制求和 {

    public String addBinary(String a, String b) {
        if(a.length() > b.length()){
            b = "0".repeat(a.length() - b.length()).concat(b);
        }else {
            a = "0".repeat(b.length() - a.length()).concat(a);
        }
        int i = a.length()-1;
        StringBuilder sb = new StringBuilder();
        int save = 0;
        while (i>=0){
            char aa = a.charAt(i);
            char bb = b.charAt(i);
            if(aa+bb+save-2*'0'>1){
                sb.append(aa+bb+save-2*'0'>2?'1':'0');
                save=1;
            }else {
                sb.append(aa+bb+save-2*'0'>0?'1':'0');
                save=0;
            }
            i--;
        }
        if(save == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
