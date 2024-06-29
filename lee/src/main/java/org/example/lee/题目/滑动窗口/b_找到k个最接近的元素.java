package org.example.lee.题目.滑动窗口;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class b_找到k个最接近的元素 {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    Deque<Integer> list = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      if (i >= k) {
        if (Math.abs(list.peekFirst() - x) > Math.abs(arr[i] - x)) {
          list.pollFirst();
          list.offerLast(arr[i]);
        } else if (arr[i] > x) {
          break;
        }
      } else {
        list.offerLast(arr[i]);
      }
    }
    return new ArrayList<>(list);
  }
}
