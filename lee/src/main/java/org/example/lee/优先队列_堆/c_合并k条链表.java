package org.example.lee.优先队列_堆;

import org.example.lee.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class c_合并k条链表 {


    /**
     * merge klists
     * 只会两种方法 第一种用优先队列做 第二种就模仿之前的合并两条队列再扩展一下
     * @param lists lists
     * @return {@link ListNode}
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode list : lists){
            if(list!=null){
                queue.offer(list);
            }
        }
        ListNode head = null,save = null;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            if(poll.next!=null){
                queue.offer(poll.next);
            }
            if(head!=null){
                head.next = poll;
                head = head.next;
            }else {
                head = poll;
                save = head;
            }
        }
        return  save;
    }
}
