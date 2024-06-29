package org.example.lee.算法实现;

public class FloydWarshall {

  public static void main(String[] args) {
    // 定义图的加权矩阵
    int INF = Integer.MAX_VALUE; // 表示无穷大，表示两点间没有直接路径
    int[][] graph = {
        {0, 2, 3, 1},
        {4, 0, INF, INF},
        {INF, INF, 0, 3},
        {3, INF, INF, 0}
    };

    int n = graph.length; // 节点的数量
    int[][] dist = new int[n][n];

    // 初始化距离矩阵
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == INF) {
          dist[i][j] = INF;
        } else {
          dist[i][j] = graph[i][j];
        }
      }
    }

    // Floyd-Warshall 算法
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][k] != INF && dist[k][j] != INF) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
    }

    // 输出任意两点间的最短路径距离
    System.out.println("Shortest distances between every pair of vertices:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (dist[i][j] == INF) {
          System.out.print("INF ");
        } else {
          System.out.print(dist[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}

