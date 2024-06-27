package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import javax.swing.PopupFactory;

public class c_重新安排路程 {
    public static void main(String[] args) {
        String[][] array =    {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        List<List<String>> list = Arrays.stream(array)
            .map(Arrays::asList)
            .collect(Collectors.toList());
    }

    /**
     * solution
     * 不好评价 干脆就记住这个算法吧
     * https://leetcode.cn/problems/reconstruct-itinerary/solutions/389885/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
     * @author 刘家辉
     * @date 2024/05/06
     */
    class Solution{
        public Map<String, PriorityQueue<String>> map = new HashMap<>();
        public List<String> list = new ArrayList<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets){
                map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                map.get(ticket.get(0)).offer(ticket.get(1));
            }
            dfs("JFK");
            Collections.reverse(list);
            return list;
        }
        void dfs(String str){
            PriorityQueue<String> queue = map.get(str);
            while (!queue.isEmpty()){
                dfs(queue.poll());
            }
            list.add(str);
        }
    }

    class Solution1 {
        public Map<Object,Object> map = new HashMap<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            tickets.sort(Comparator.comparing(a -> a.get(1)));
            List<String> list = new ArrayList<>();
            tool(tickets,list,null);
            return list;
        }

        boolean tool(List<List<String>> tickets,List<String> list,List<String> save){
            if(list.size() == tickets.size()){
                list.add(save.get(1));
                return true;
            }
            for (int i = 0; i < tickets.size(); i++) {
                if(map.containsKey(i)){
                    continue;
                }
                if(save!=null &&!Objects.equals(tickets.get(i).get(0), save.get(1))){
                    continue;
                }
                if(list.isEmpty()&&!Objects.equals(tickets.get(i).get(0), "JFK")){
                        continue;
                }
                map.put(i,1);
                list.add(tickets.get(i).get(0));
                if(tool(tickets,list,tickets.get(i))){
                    return true;
                }
                list.remove(list.size()-1);
                map.remove(i);
            }
            return false;
        }
    }
}
