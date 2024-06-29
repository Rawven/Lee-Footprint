package org.example.lee.题目.栈;

import java.util.Stack;

public class b_逆波兰表达式求值 {

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    int len = tokens.length;
    int i = 0, a1, b1, add;
    while (i < len) {
      String a = tokens[i];
      switch (a) {
        case "+":
          a1 = stack.pop();
          b1 = stack.pop();
          add = (a1 + b1);
          break;
        case "-":
          a1 = stack.pop();
          b1 = stack.pop();
          add = (b1 - a1);
          break;
        case "*":
          a1 = stack.pop();
          b1 = stack.pop();
          add = (a1 * b1);
          break;
        case "/":
          a1 = stack.pop();
          b1 = stack.pop();
          add = (b1 / a1);
          break;
        default:
          add = Integer.parseInt(a);
          break;
      }
      stack.add(add);
      i++;
    }
    return stack.peek();
  }
}
