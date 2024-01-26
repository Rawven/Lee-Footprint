package org.example.lee.题目.矩阵;

public class b_有效的数独 {


    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * is valid sudoku
     * 矩阵 第一次做
     *
     * @param board board
     * @return boolean
     */
    public boolean isValidSudoku(char[][] board) {
        //行
        int[][] row = new int[9][9];
        //列
        int[][] columns = new int[9][9];
        //九宫格
        int[][][] subboxes = new int[3][3][9];
        //【9】代表数字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    //对应的行
                    row[i][c - 49]++;
                    //对应的列
                    columns[j][c - 49]++;
                    //对应位置的九宫格
                    subboxes[i / 3][j / 3][c - 49]++;
                    if (row[i][c - 49] > 1 || columns[j][c - 49] > 1 ||
                            subboxes[i / 3][j / 3][c - 49] > 1
                    ) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
