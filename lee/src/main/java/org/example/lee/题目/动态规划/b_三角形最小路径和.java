package org.example.lee.题目.动态规划;

import java.util.ArrayList;
import java.util.List;

public class b_三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> objects = new ArrayList<>();
        objects.add(new ArrayList<>() {{
            add(2);
        }});
        objects.add(new ArrayList<>() {{
            add(3);
            add(4);
        }});
        objects.add(new ArrayList<>() {{
            add(6);
            add(5);
            add(7);
        }});
        objects.add(new ArrayList<>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});

        minimumTotal(objects);
    }

    /**
     * 1.状态 最小路径和
     * 2.  对应关系    a[i][j] ->triangle[i][j]+ min(a[i+1][j],a[i+1][j+1])
     * <p>
     * 自底向上  dfs会超时
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }


}
