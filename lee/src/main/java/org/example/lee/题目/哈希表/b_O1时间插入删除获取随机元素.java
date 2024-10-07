package org.example.lee.题目.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b_O1时间插入删除获取随机元素 {


	class RandomizedSet {

		private HashMap<Integer, Integer> map;
		private List<Integer> list;

		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>() {
			};
		}

		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			} else {
				list.add(val);
				map.put(val, list.size() - 1);
			}
			return true;
		}

		public boolean remove(int val) {
			if (map.containsKey(val)) {
				list.set(map.get(val), list.get(list.size() - 1));
				map.put(list.get(list.size() - 1), map.get(val));
				list.remove(list.size() - 1);
				map.remove(val);
				return true;
			}
			return false;
		}

		public int getRandom() {
			return list.get((int) (Math.random() * list.size()));
		}
	}
}
