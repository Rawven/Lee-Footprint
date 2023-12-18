package org.example.lee.题目.优先队列_堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class b_拼车 {

    /**
     * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
     * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
     * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
     * car pooling
     *
     * 差分数组 TODO//人话
     *          求出每个位置的差值 然后再算
     * @param trips    trips
     * @param capacity capacity
     * @return boolean
     */
    public boolean carPooling(int[][] trips, int capacity){
        int length=0;
        //通过最长的终点to来找到需要的数组长度
        for (int [] trip: trips) {
            length = Math.max(trip[2],length);
        }
        int[] arr = new int[length+1];
        //遍历 求出绝对值
        for (int[] trip: trips) {
            arr[trip[1]]+=trip[0];
            arr[trip[2]]-=trip[0];
        }
        int count = 0;
        //一个个加然后判断
        for (int i: arr) {
            count+=i;
            if(count>capacity){
                return false;
            }
        }
        return true;
    }


    /**
     * 笨笨的双优先队列做法
     *
     * @param trips    trips
     * @param capacity capacity
     * @return boolean
     */
    public boolean carPooling1(int[][] trips, int capacity) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> queueY = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] arr:trips) {
            if(arr!=null){
                queue.offer(arr);
                queueY.offer(arr);
            }
        }
        int[] poll = queue.poll();
        int[] poll2 = queueY.poll();

        do{
            while (capacity>=0&&poll!=null&&(poll2 == null || poll[1]<poll2[2])){
                capacity-=poll[0];
                poll=queue.poll();
            }
            if(capacity<0){
                return false;
            }
            while (capacity>=0&&poll2!=null&&( poll==null||poll2[2]<=poll[1])){
                capacity+=poll2[0];
                poll2=queueY.poll();
            }
            if(capacity<0){
                return false;
            }
        }while (!(queue.isEmpty()&&queueY.isEmpty()));
        return true;
    }
}
