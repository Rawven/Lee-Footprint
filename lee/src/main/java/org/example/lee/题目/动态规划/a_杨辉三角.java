package org.example.lee.题目.动态规划;

import java.util.ArrayList;
import java.util.List;

public class a_杨辉三角 {


  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> key = new ArrayList<>();
    key.add(new ArrayList<>() {{
      add(1);
    }});
    if (numRows == 1) {
      return key;
    }
    key.add(new ArrayList<>() {{
      add(1);
      add(1);
    }});
    for (int i = 2; i < numRows; i++) {
      ArrayList<Integer> list = new ArrayList<>() {{
        add(1);
      }};
      List<Integer> before = key.get(i - 1);
      for (int j = 1; j < i; j++) {
        list.add(before.get(j) + before.get(j - 1));
      }
      list.add(1);
      key.add(list);
    }
    return key;
  }
}
