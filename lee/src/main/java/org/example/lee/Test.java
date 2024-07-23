package org.example.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> awe = new ArrayList<>();
    char[][] arr = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = '.';
      }
    }
    tool(awe,new ArrayList<>(),arr, 0, n);
    return awe;
  }


  public void tool(List<List<String>> awe,List<String> arr, char[][] tap, int row, int n) {
    if (row == n) {
      ArrayList<String> strings = new ArrayList<>(arr);
      awe.add(strings);
      return;
    }
    for (int i = 0; i < n; i++) {
      if (tool1(row,i,tap)) {
        tap[row][i]='Q';
        arr.add(new String(tap[row]));
        tool(awe, arr,tap, row + 1, n);
        arr.remove(arr.size()-1);
        tap[row][i]='.';
      }
    }
  }

  public Boolean tool1(int x, int y, char[][] tap) {
    for (int i = 0; i < x; i++) {
      if (tap[i][y] == 'Q'){
        return false;
      }
    }
    for (int i = x-1,j = y -1; i>=0 && j >=0; i--,j--) {
      if (tap[i][j] == 'Q'){
        return false;
      }
    }
    for (int i = x-1,j = y+1; i>=0 && j <tap[0].length; i--,j++) {
      if (tap[i][j] == 'Q'){
        return false;
      }
    }
    return true;
  }

}
