package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * b 组合总和
 *
 * @author 刘家辉
 * @date 2023/11/29
 */
public class b_组合总和 {
    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }


    /**
     * combination sum
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * @param candidates candidates
     * @param target     target
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int length = candidates.length;
        //排序 方便 49行剪枝
        Arrays.sort(candidates);
        tool(lists, list, 0, 0, candidates, target, 0, length);
        return lists;
    }

    public static void tool(List<List<Integer>> saveL, List<Integer> save,
                            int initNum, int index, int[] candidates, int target, int begin, int len) {
        if (initNum == target) {
            ArrayList<Integer> list = new ArrayList<>(save);
            saveL.add(list);
            return;
        }
        for (int i = begin; i < len; i++) {
            int i1 = candidates[i];
            initNum += i1;
            if (initNum > target) {
                return;
            }
            save.add(index, i1);
            tool(saveL, save, initNum, index + 1, candidates, target, i, len);
            initNum -= i1;
            save.remove(index);
        }
    }
}
