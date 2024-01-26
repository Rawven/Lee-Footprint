package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class b_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i : nums) {
            queue.offer(i);
        }
        tool(queue, 0, list, new ArrayList<>(), nums.length);
        return list;
    }

    void tool(LinkedList<Integer> queue, int start, List<List<Integer>> list, List<Integer> save, int len) {
        if (start == len) {
            list.add(new ArrayList<>(save));
        }
        for (int i = start; i < len; i++) {
            Integer poll = queue.poll();
            save.add(poll);
            tool(queue, start + 1, list, save, len);
            save.remove(save.size() - 1);
            queue.offer(poll);
        }
    }
}
