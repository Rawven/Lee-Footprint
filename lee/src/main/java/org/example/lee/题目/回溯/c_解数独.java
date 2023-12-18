package org.example.lee.题目.回溯;

public class c_解数独 {
    public static void main(String[] args) {
        char[][] sudokuBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(sudokuBoard);
    }


    /**
     * solve sudoku
     * 解数独 回溯 做过N皇后思路便很明确
     * @param board board
     */
    public static void solveSudoku(char[][] board) {
        solution(board, 0,0);
    }

    public static boolean solution(char[][] board, int row, int columns) {
        if (row == 9) {
            return true;
        }
        while (row<9&&columns<9&&board[row][columns]!='.'){
            if(columns !=8) {
                columns++;
            }else {
                columns=0;
                row++;
            }
        }
        if(!(row ==9||columns==9)) {
            for (int j = 1; j <= 9; j++) {
                char key = (char) ('0' + j);
                if (isValid(board, key, 9, row, columns)) {
                    board[row][columns] = key;
                    boolean solution;
                    if (columns == 8) {
                        solution = solution(board, row + 1, 0);
                    } else {
                        solution = solution(board, row, columns + 1);
                    }
                    if (!solution) {
                        board[row][columns] = '.';
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;

    }

    public static boolean isValid(char[][] board, char key, int n, int row, int columns) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == key) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][columns] == key) {
                return false;
            }
        }
        int r = row / 3, c = columns / 3;
        for (int a = r * 3; a < r * 3 + 3; a++) {
            if(a == row){
                continue;
            }
            for (int b = c * 3; b < c * 3 + 3; b++) {
                if(b == columns){
                    continue;
                }
                if (board[a][b] == key) {
                    return false;
                }
            }
        }
        return true;
    }
}
