package org.example.lee.题目.动态规划;

public class b_不同路径2 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    int mS, nS;
    mS = nS = 1 - obstacleGrid[m - 1][n - 1];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (obstacleGrid[i][j] != 1) {
          if (i == m - 1) {
            dp[i][j] = mS;
          } else if (j == n - 1) {
            dp[i][j] = nS;
          } else {
            dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
          }
        } else {
          mS = i == m - 1 ? 0 : 1;
          nS = j == n - 1 ? 0 : 1;
        }
      }
    }
    return dp[0][0];

  }


}
