package org.example.lee.题目.队列;

import java.util.LinkedList;

public class a_最近的请求次数 {

  class RecentCounter {

    public LinkedList<Integer> list;

    public RecentCounter() {
      list = new LinkedList<>();
    }

    public int ping(int t) {
      while (!list.isEmpty() && list.getFirst() < t - 3000) {
        list.removeFirst();
      }
      list.addLast(t);
      return list.size();
    }
  }
}
