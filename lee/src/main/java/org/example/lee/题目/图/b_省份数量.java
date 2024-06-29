package org.example.lee.题目.图;

public class b_省份数量 {

  public int findCircleNum(int[][] isConnected) {
    int num = isConnected.length;
    boolean[] existed = new boolean[num];
    int key = 0;
    for (int i = 0; i < num; i++) {
      if (!existed[i]) {
        dfs(isConnected, existed, i);
        key++;
      }
    }
    return key;
  }

  private void dfs(int[][] connected, boolean[] existed, int i) {
    for (int j = 0; j < connected.length; j++) {
      if (connected[i][j] == 1 && !existed[j]) {
        existed[j] = true;
        dfs(connected, existed, j);
      }
    }
  }
}
