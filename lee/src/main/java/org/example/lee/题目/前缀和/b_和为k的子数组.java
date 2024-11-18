package org.example.lee.题目.前缀和;

import java.util.HashMap;
import java.util.Map;

public class b_和为k的子数组 {

	public int subarraySum(int[] nums, int k) {
         Map<Integer,Integer> map = new HashMap<>();
		 int result = 0, sum = 0;
		 map.put(0,1);
		 for (int num : nums){
			 sum += num;
			 //如果前面的前缀子串有sum-k,那剩下的sum减去那个前缀子串的剩余部分就是k
			 if(map.containsKey(sum - k)){
				 result += map.get(sum - k);
			 }
			 map.put(sum,map.getOrDefault(sum,0)+1);
		 }
		 return result;
	}
}
