package org.example.lee.题目.贪心;

import org.example.lee.model.TreeNode;
import org.example.lee.util.LeeUtil;

public class c_监控二叉树 {
    public int key = 0;
    public int minCameraCover(TreeNode root) {
       //根节点返回0的补偿
       if(tool(root)==0){
            key++;
       }
        return key;
    }

     int tool(TreeNode node){
        //0 我需要观测
        //1 我将成为摄像头观测我的子节点
        //2 我被观测了
        int tool = -1,tool1 = -1;
        if(node.left!=null) {
            tool = tool(node.left);
        }
        if(node.right!=null) {
            tool1 = tool(node.right);
        }
        if((tool == -1 ||tool == 2) && (tool1 == -1 ||tool1 == 2)){
            //自己是叶子节点 或者 子节点都被观测
            //我需要观测
            return 0;
        }
        if(tool == 0 || tool1 == 0){
            //有无观测节点 我要成为摄像头
            key++;
            //1 我是摄像头
            return 1;
        }
        if(tool == 1 || tool1 == 1){
            //2 我被观测了
            return 2;
        }
        return -1;
    }
}
