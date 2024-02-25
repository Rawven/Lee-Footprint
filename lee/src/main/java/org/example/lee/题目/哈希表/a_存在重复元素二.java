package org.example.lee.题目.哈希表;

import java.util.HashMap;

public class a_存在重复元素二 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int a=0,b=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (a < nums.length) {
            if(a>=k+1){
                map.remove(nums[b]);
                b++;
            }
            if(map.containsKey(nums[a])){
                return true;
            }
            map.put(nums[a],1);
            a++;
        }
        return false;
    }
}
