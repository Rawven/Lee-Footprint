package org.example.lee.题目.栈;

import java.util.Stack;

public class a_删除字符串中的所有相邻重复项 {

  public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while (i < s.length()) {
      if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
        stack.pop();
      } else {
        stack.push(s.charAt(i));
      }
      i++;
    }
    StringBuilder builder = new StringBuilder();
    for (Character c : stack) {
      builder.append(c);
    }
    return builder.toString();
  }

  public String removeDuplicates1(String s) {
    StringBuilder builder = new StringBuilder();
    char[] array = s.toCharArray();
    int i = 0;
    while (i < array.length) {
      int len = builder.length() - 1;
      if (builder.length() > 0 && builder.charAt(len) == array[i]) {
        builder.deleteCharAt(len);
      } else {
        builder.append(array[i]);
      }
      i++;
    }
    return builder.toString();
  }
}
