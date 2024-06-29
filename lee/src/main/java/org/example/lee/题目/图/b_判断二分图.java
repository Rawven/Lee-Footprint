package org.example.lee.题目.图;

import org.example.lee.util.LeeUtil;

public class b_判断二分图 {

  public static void main(String[] args) {
    isBipartite(LeeUtil.getArray("[[3],[2,4],[1],[0,4],[1,3]]"));
  }

  public static boolean isBipartite(int[][] graph) {
    int[] nodes = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (nodes[i] == 0) {
        nodes[i] = 1;
      }
      if (!dfs(graph, i, nodes)) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfs(int[][] graph, int index, int[] nodes) {
    int key;
    if (nodes[index] == 1) {
      key = 2;
    } else {
      key = 1;
    }
    for (int i = 0; i < graph[index].length; i++) {
      int j = graph[index][i];
      if (nodes[j] == 0) {
        nodes[j] = key;
        dfs(graph, j, nodes);
      } else if (nodes[j] == nodes[index]) {
        return false;
      }
    }
    return true;
  }
}
