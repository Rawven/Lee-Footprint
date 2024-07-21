package org.example.lee.题目.滑动窗口;


import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

public class c_滑动窗口最大值 {

  /**
   * max sliding window 100ms做法
   *
   * @param nums nums
   * @param k    k
   * @return {@link int[]}
   */
  public static int[] maxSlidingWindow1(int[] nums, int k) {
    PriorityQueue<int[]> queue = new PriorityQueue<>(
        Comparator.comparingInt(o -> -o[0]));
    int[] answer = new int[nums.length - k + 1];
    int index = 0;
    for (int i = 0; i < k; i++) {
      queue.offer(new int[]{nums[i], i});
    }
    answer[index++] = (Objects.requireNonNull(queue.peek())[0]);
    for (int i = k; i < nums.length; i++) {
      queue.offer(new int[]{nums[i], i});
      while (Objects.requireNonNull(queue.peek())[1] < i - k + 1) {
        queue.poll();
      }
      answer[index++] = (Objects.requireNonNull(queue.peek())[0]);
    }
    return answer;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    //单调队列 存储下标
    Deque<Integer> deque = new LinkedList<>();
    int[] answer = new int[nums.length - k + 1];
    int index = 0;
    for (int i = 0; i < k; i++) {
      //比最后元素大直接炒掉最后元素 反复炒直到小于最后一个元素
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      //入队列
      deque.offerLast(i);
    }
    answer[index++] = nums[deque.peekFirst()];
    for (int i = k; i < nums.length; i++) {
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      //如果最前方的id不在窗口内 反复炒直到在窗口里面
      while (deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      answer[index++] = nums[deque.peekFirst()];
    }
    return answer;
  }
}
