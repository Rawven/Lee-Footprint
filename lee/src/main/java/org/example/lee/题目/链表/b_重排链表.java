package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;
import org.example.lee.util.LeeUtil;

import java.util.List;
import java.util.Stack;

public class b_重排链表 {

    public  void reorderList(ListNode head) {
         ListNode last = head;
         Stack<ListNode> stack = new Stack<>();
         while (last!=null) {
             stack.add(last);
             last = last.next;
         }
         while (head != stack.peek()&&head.next != stack.peek()){
             ListNode node =head.next;
             ListNode node1 = stack.pop();
             head.next = node1;
             node1.next = node ;
             head = node;
         }
        if(head.next == stack.peek()) {
            head.next.next = null;
        }else{
            head.next =null;
        }
    }
}
