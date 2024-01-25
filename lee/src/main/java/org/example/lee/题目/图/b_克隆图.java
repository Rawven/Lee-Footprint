package org.example.lee.题目.图;

import org.example.lee.model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class b_克隆图 {

    /**
     * clone graph
     *给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[重名]）。
     * @param node node
     * @return {@link 重名}
     */
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }return dfs(node,new HashMap<>());
    }
    Node dfs(Node node, Map<Integer,Node> map){
        Node node2 = new Node();
        node2.val = node.val;
        node2.neighbors = new ArrayList<>();
        map.put(node.val,node2);
        for( Node node1 : node.neighbors){
            if(map.containsKey(node1.val)){
                node2.neighbors.add(map.get(node1.val));
            }else {
                node2.neighbors.add(dfs(node1,map));
            }
        }
        return node2;
    }
}
