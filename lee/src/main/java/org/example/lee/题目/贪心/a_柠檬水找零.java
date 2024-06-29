package org.example.lee.题目.贪心;

public class a_柠檬水找零 {

  public boolean lemonadeChange(int[] bills) {
    int[] array = new int[3];
    for (int bill : bills) {
      if (bill == 5) {
        array[0]++;
      } else if (bill == 10) {
        if (array[0] == 0) {
          return false;
        }
        array[0]--;
        array[1]++;
      } else if (bill == 20) {
        if (array[1] > 0 && array[0] > 0) {
          array[1]--;
          array[0]--;
          array[2]++;
        } else if (array[0] >= 3) {
          array[0] -= 3;
          array[2]++;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
