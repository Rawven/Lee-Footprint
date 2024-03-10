package org.example.lee.题目.动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class b_单词拆分 {

    /**
     * word break
     *  dp 记住前一状态  边界问题也要会处理
     * @param s        s
     * @param wordDict word dict
     * @return boolean
     */
    public  boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if(dp[j] && set.contains(s.substring(j,i+1))){
                    dp[i+1]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
