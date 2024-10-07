package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.List;

public class b_组合总和Ⅲ {


	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> lists = new ArrayList<>();
		tool(lists, new ArrayList<>(), 0, 0, 0, k, n);
		return lists;
	}

	void tool(List<List<Integer>> lists, List<Integer> list, int help, int start, int now,
	          int k, int n) {
		if (start != 0) {
			list.add(start);
			if (now == k) {
				if (start + help == n) {
					lists.add(new ArrayList<>(list));
				}
				return;
			}
			help += start;
		}
		for (int i = start + 1; i <= 9; i++) {
			tool(lists, list, help, i, now + 1, k, n);
			list.remove(list.size() - 1);
		}
	}
}
