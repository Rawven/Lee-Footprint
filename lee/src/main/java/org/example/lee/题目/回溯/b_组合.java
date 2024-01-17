package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * b 组合
 *
 * @author 刘家辉
 * @date 2024/01/17
 */
public class b_组合 {
    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
         tool(list,new ArrayList<>(), 1,n, k);
         return list;
    }

    static void  tool(List<List<Integer>> list, List<Integer> save,int start ,int n, int k) {
        if (save.size() == k) {
            ArrayList<Integer> integers = new ArrayList<>(save);
            list.add(integers);
            return;
        }
        for (int i = start; i <= n; i++) {
                save.add(i);
                tool(list,save,i+1,n,k);
                save.remove(save.size()-1);
        }
    }
}
