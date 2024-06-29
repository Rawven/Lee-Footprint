package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.List;

public class b_分割回文串 {

  public List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    tool(list, new ArrayList<>(), s, 0);
    return list;
  }

  void tool(List<List<String>> lists, List<String> list, String str, int start) {
    if (start == str.length()) {
      lists.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < str.length(); i++) {
      if (tool(str, start, i)) {
        list.add(str.substring(start, i + 1));
        tool(lists, list, str, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  boolean tool(String str, int start, int end) {
    while (start <= end) {
      if (str.charAt(start++) != str.charAt(end--)) {
        return false;
      }
    }
    return true;
  }

}
