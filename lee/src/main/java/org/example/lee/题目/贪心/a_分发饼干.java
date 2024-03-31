package org.example.lee.题目.贪心;

import java.lang.reflect.Array;
import java.util.Arrays;

public class a_分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si=s.length-1,anw=0;
        for (int i = g.length-1; i >=0 && si>=0; i--) {
            if(s[si]>=g[i]){
                si--;
                anw++;
            }
        }
        return anw;
    }
}
