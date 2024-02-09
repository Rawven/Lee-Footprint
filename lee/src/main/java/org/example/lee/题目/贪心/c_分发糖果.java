package org.example.lee.题目.贪心;

public class c_分发糖果 {

    /**
     * candy
     *   扫描两次 双贪心得出全局最优
     * @param ratings ratings
     * @return int
     */
    public int candy(int[] ratings) {
        int key = 0, len = ratings.length, index = 1;
        int[] candyArr = new int[len];
        candyArr[0] = 1;
        while (index < len) {
            if (ratings[index] < ratings[index - 1]) {
                candyArr[index] = 1;
                candyArr[index - 1] = candyArr[index - 1] > 1 ? candyArr[index - 1] : 2;
            } else if (ratings[index] > ratings[index - 1]) {
                candyArr[index] = candyArr[index - 1] + 1;
            } else {
                candyArr[index] = 1;
            }
            index++;
        }
        index--;
        while (index >0 ) {
            if (ratings[index] < ratings[index - 1]) {
                if(candyArr[index] >= candyArr[index-1]){
                    candyArr[index-1]=candyArr[index]+1;
                }
            }
            key += candyArr[index];
            index--;
        }
        return key + candyArr[0];
    }
}
