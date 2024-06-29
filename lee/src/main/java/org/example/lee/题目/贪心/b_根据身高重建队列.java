package org.example.lee.题目.贪心;

import java.util.Arrays;
import java.util.LinkedList;

public class b_根据身高重建队列 {

  public int[][] reconstructQueue(int[][] people) {
    LinkedList<int[]> list = new LinkedList<>();
    //重点在排序  让身高高的在前面 因为比他们高的人一定少
    //然后让k小的在前面,前面没人的先排
    Arrays.sort(people,
        (a, b) -> a[0] == b[0] ? a[1] - b[1] : -(a[0] - b[0])
    );
    for (int[] person : people) {
      //直接根据前面的人数来当作下标索引 主打一个贪心，因为我前面有n个人，那我的
      //下标肯定是n或者之后，要这样贪心就得前面的排序当基础
      //也利用到了LinkedList的特性
      list.add(person[1], person);
    }
    return list.toArray(new int[people.length][]);
  }
}
