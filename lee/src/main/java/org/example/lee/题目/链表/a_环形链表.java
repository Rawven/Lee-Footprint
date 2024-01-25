package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;



public class a_环形链表 {

    /**
     * has cycle
     * 快慢指针
     * @param head head
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        ListNode low =head, fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            if(fast==low){
                return true;
            }
        }
        return false;
    }
}
