package org.example.lee.dp;

public class a_爬楼梯 {


    /**
     * climb stairs
     * TODO :
     *  1.状态定义 dp[i] = 爬到 i 阶的方案数
     *  2. 状态转移方程 ： dp[i] = dp[i-1] + dp[i-2];
     *  3. 初始条件 ： dp[1]=1 dp[2] =2
     *  4. 返回值： dp[n]
     * @param n n
     * @return int
     */
    public int climbStairs(int n) {
        if(n ==1){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[1]=1;dp[2]=2;
        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return  dp[n];
    }
}
