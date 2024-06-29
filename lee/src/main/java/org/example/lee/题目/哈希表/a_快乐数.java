package org.example.lee.题目.哈希表;

import java.util.HashMap;

public class a_快乐数 {

  public boolean isHappy(int n) {
    //哈希 return tool(n,new HashMap<Integer,Integer>());
        /* 双指针 int slow = n,fast = tool(n);
        while (slow!=fast && fast!=1){
            slow = tool(slow);
            fast = tool(tool(fast));
        }
        return fast==1;*/
    //永远开心
    return true;
  }

  /**
   * tool 双指针
   *
   * @param n n
   * @return int
   */
  public int tool(int n) {
    int num = 0;
    while (n != 0) {
      num += (n % 10) * (n % 10);
      n /= 10;
    }
    return num;
  }

  /**
   * tool 哈希法
   *
   * @param n   n
   * @param map map
   * @return boolean
   */
  public boolean tool(int n, HashMap<Integer, Integer> map) {
    int num = 0;
    if (map.containsKey(n)) {
      return false;
    }
    map.put(n, 1);
    while (n != 0) {
      num += (n % 10) * (n % 10);
      n /= 10;
    }
    return num == 1 || tool(num, map);
  }
}
