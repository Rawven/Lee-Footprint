package org.example.lee.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * b 组合总和2
 * @author 刘家辉
 * @date 2023/11/29
 */
public class b_组合总和2 {

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 注意：解集不能包含重复的组合。
     * combination sum2
     * @param candidates candidates
     * @param target     target
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(candidates);
        int[] array = new int[candidates.length];
        int index =0;
        for (int i: candidates) {
             if(map.containsKey(i)){
                 map.put(i,map.get(i)+1);
             }else {
                 array[index]=i;
                 index++;
                 map.put(i,1);
             }
        }
        tool(lists, list, 0,  0,target, 0, index,array,map);
        return lists;
    }

    public static void tool (List<List<Integer>> saveL,List<Integer> save,
                             int initNum, int index,int target,int begin,int len,int[] array,HashMap<Integer, Integer> map){
        if(initNum == target){
            ArrayList<Integer> list = new ArrayList<>(save);
            saveL.add(list);
            return;
        }
        for (int i=begin;i<len;i++) {
            int i1 = array[i];
            int saveT=map.get(i1);
            if(saveT>0) {
                initNum += i1;
                if(initNum>target){
                    return;
                }
                save.add(index, i1);
                map.put(i1,saveT-1);
                tool(saveL, save, initNum, index+1,target, i, len, array, map);
                initNum -= i1;
                save.remove(index);
                map.put(i1,saveT);
            }
        }
    }
}
