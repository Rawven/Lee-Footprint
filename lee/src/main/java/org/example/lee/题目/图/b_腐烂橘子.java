package org.example.lee.题目.图;

import java.util.LinkedList;
import java.util.Queue;

public class b_腐烂橘子 {

  public int num = 0;

  public int orangesRotting(int[][] grid) {
    int x = grid.length, y = grid[0].length, all = x * y;
    Queue<int[]> queue = new LinkedList<>();
    // 查出所有感染的 然后再bfs 如果queue为0还没感染完全则-1
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (grid[i][j] == 2) {
          num++;
          queue.add(new int[]{i, j});
        } else if (grid[i][j] == 0) {
          num++;
        }
      }
    }
    if (num == all) {
      return 0;
    }
    if (queue.isEmpty()) {
      return -1;
    }
    int index = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] poll = queue.poll();
        tool(queue, poll[0] - 1, poll[1], grid);
        tool(queue, poll[0], poll[1] - 1, grid);
        tool(queue, poll[0] + 1, poll[1], grid);
        tool(queue, poll[0], poll[1] + 1, grid);
      }
      index++;
    }
    if (num != all) {
      return -1;
    }
    return index - 1;
  }

  void tool(Queue<int[]> queue, int i, int j, int[][] grid) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2
        || grid[i][j] == 0) {
      return;
    }
    if (grid[i][j] == 1) {
      num++;
      grid[i][j] = 2;
      queue.add(new int[]{i, j});
    }
  }


}
