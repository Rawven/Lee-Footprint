package org.example.lee.util;

import org.example.lee.model.ListNode;

public class ListNodeUtil {
    public static ListNode arrayToListNode(int[] arr) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int i : arr) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return dummyHead.next;
    }
}
