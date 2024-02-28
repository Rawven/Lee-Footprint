package org.example.lee.util;

import java.util.Arrays;

public class LeeUtil {
    public static int[][] getArray(String str){
        str = str.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
        String[] rows = str.split("\\],\\[");

        int[][] arr = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            arr[i] = Arrays.stream(rows[i].split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        return arr;
    }
    public static void printArray(String str) {
        int[][] arr = getArray(str);

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
