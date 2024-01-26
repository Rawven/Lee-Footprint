package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

import java.util.HashMap;

public class a_删除排序链表中的重复元素 {
    /**
     * delete duplicates
     *
     * @param head head
     * @return {@link ListNode}
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode rh = head, h = null;
        while (head != null) {
            if (h == null || head.val != h.val) {
                h = head;
            } else {
                h.next = head.next;
            }
            head = head.next;
        }
        return rh;
    }

    /**
     * delete duplicates
     * 适用于未排序
     *
     * @param head head
     * @return {@link ListNode}
     */
    public ListNode deleteDuplicates1(ListNode head) {
        HashMap<Object, Object> map = new HashMap<>();
        ListNode rh = head, h = null;
        while (head != null) {
            if (!map.containsKey(head.val)) {
                map.put(head.val, 1);
                h = head;
            } else {
                h.next = head.next;
            }
            head = head.next;
        }
        return rh;
    }
}
