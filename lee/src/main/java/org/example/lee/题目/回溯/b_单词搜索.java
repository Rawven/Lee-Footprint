package org.example.lee.题目.回溯;

public class b_单词搜索 {

  static boolean dfs(int save, int i, int j, char[][] board, String word) {
    if (!(i >= 0 && j >= 0 && i < board.length && j < board[0].length)) {
      return false;
    }
    if (word.charAt(save) == board[i][j]) {
      if (save == word.length() - 1) {
        return true;
      }
      save++;
      char c = board[i][j];
      board[i][j] = '1';
      boolean dfs = dfs(save, i + 1, j, board, word);
      boolean dfs1 = dfs(save, i - 1, j, board, word);
      boolean dfs2 = dfs(save, i, j + 1, board, word);
      boolean dfs3 = dfs(save, i, j - 1, board, word);
      board[i][j] = c;
      return dfs || dfs1 || dfs2 || dfs3;
    }
    return false;
  }

  public boolean exist(char[][] board, String word) {

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (word.charAt(0) == board[i][j]) {
          boolean dfs = dfs(0, i, j, board, word);
          if (dfs) {
            return true;
          }
        }
      }
    }
    return false;
  }


}
