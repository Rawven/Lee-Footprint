package org.example.lee.题目.动态规划;

public class b_最小路径和 {

    /**
     * 动态规划[i]
     *
     * @param obstacleGrid
     * @return
     */
    public int minPathSum(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = obstacleGrid[i][j];
                } else if (i == 0) {
                    dp[i][j] = obstacleGrid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = obstacleGrid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = obstacleGrid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
