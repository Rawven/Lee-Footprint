package org.example.lee.题目.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import org.mockito.internal.configuration.injection.SpyOnInjectedFieldsHandler;

public class b_除法求值 {
    public double[] calcEquation(List<List<String>> equations,
        double[] values, List<List<String>> queries) {
            int num = 0;
            // 现将条件转化为带权值有向图
            HashMap<String,Integer> map = new HashMap<>();
            //获取图的所有结点
            for (List<String> list : equations){
                if(!map.containsKey(list.get(0))){
                    map.put(list.get(0),num++);
                }
                if(!map.containsKey(list.get(1))){
                    map.put(list.get(1),num++);
                }
            }
            double[] key = new double[queries.size()];
            List<Pair>[] pairs = new List[num];
            for (int i = 0; i < num; i++) {
                pairs[i] = new ArrayList<>();
            }
            //为结点赋值
            for (int i = 0; i< equations.size();i++){
                int a = map.get(equations.get(i).get(0)),
                    b = map.get(equations.get(i).get(1));
                pairs[a].add(new Pair(b,values[i]));
                pairs[b].add(new Pair(a,1.0/values[i]));
            }
           //开始计算
            for (int i = 0; i < queries.size(); i++) {
                List<String> strings = queries.get(i);
                double result = -1.0;
                //判断有没有值
                if(map.containsKey(strings.get(0)) && map.containsKey(strings.get(1))){
                    int a = map.get(strings.get(0)), b =map.get(strings.get(1));
                    //自己除自己的情况
                    if(Objects.equals(a,b)){
                        result=1.0;
                    }else{
                        //开始广度优先搜索 使用队列存储
                        Queue<Integer> queue = new LinkedList<Integer>();
                        queue.offer(a);
                        double[] ratios = new double[num];
                        Arrays.fill(ratios, -1.0);
                        ratios[a] = 1.0;
                        while (!queue.isEmpty() && ratios[b]<0){
                            Integer poll = queue.poll();
                            for (Pair pair : pairs[poll]){
                                int y = pair.index;
                                double v = pair.value;
                                if(ratios[y]<0){
                                    //将权值叠加     比如 要求18/2    有18/6   6/2     则会变成3 * 3 = 9  ,最后的权值就是答案
                                    ratios[y] = ratios[poll]*v;
                                    queue.offer(y);
                                }
                            }
                        }
                        result = ratios[b];
                    }
                }
                key[i]=result;
            }
            return key;
    }


    
    class  Pair{
        public int index;
        public double value;
        
        public Pair(int index,double value){
            this.index = index;
            this.value = value;
        }
    }
}
