package org.example.lee.题目.图;

import java.util.ArrayList;
import java.util.List;

public class b_所有可能的路径 {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    list.add(0);
    dfs(0, graph, answer, list);
    return answer;
  }

  private void dfs(int i, int[][] graph, List<List<Integer>> answer,
      List<Integer> list) {
    if (i == graph.length - 1) {
      answer.add(new ArrayList<>(list));
      return;
    }

    for (int j = 0; j < graph[i].length; j++) {
      list.add(graph[i][j]);
      dfs(graph[i][j], graph, answer, list);
      list.remove(list.size() - 1);
    }
  }
}
