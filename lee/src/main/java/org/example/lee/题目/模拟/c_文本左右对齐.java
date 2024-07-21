package org.example.lee.题目.模拟;

import java.util.ArrayList;
import java.util.List;

public class c_文本左右对齐 {

  public List<String> fullJustify(String[] words, int maxWidth) {
    ArrayList<String> list = new ArrayList<>();
    int save, index = 0, help, len = words.length, a, b, c, d;
    while (index < len) {
      save = 0;
      StringBuilder stringBuilder = new StringBuilder();
      help = index;
      while (index < len && save + words[index].length() <= maxWidth) {
        save += words[index++].length() + 1;
      }
      //最后一行
      if (index == len) {
        a = 1;
      } else {
        a = maxWidth - save + index - help;
        b = index - help - 1;
        //非单个单词占一行情况
        if (b > 0) {
          if (a % b != 0) {
            c = a % b;
            d = help;
            while (c > 0) {
              words[d] = words[d].concat(" ");
              d++;
              c--;
            }
          }
          a /= b;
        }
      }
      while (stringBuilder.length() < maxWidth) {
        stringBuilder.append(words[help++]);
        if (help == index || stringBuilder.length() == maxWidth) {
          break;
        }
        stringBuilder.append(" ".repeat(Math.max(0, a)));
      }
      if (stringBuilder.length() != maxWidth) {
        stringBuilder.append(" ".repeat(Math.max(0, maxWidth - stringBuilder.length())));
      }
      list.add(stringBuilder.toString());
    }
    return list;
  }
}
