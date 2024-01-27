package org.example.lee.题目.贪心;

public class b_买股票的最佳时机 {
    /**
     * max profit
     * 就得贪   1-3+3-5 =1-5  记住
     * @param prices prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min=prices[0];
        int answer = 0;
        for(int i = 1; i<len;i++){
            if(min<prices[i]){
                answer+= prices[i]-min;
            }
            min = prices[i];
        }
        return answer;
    }
}
