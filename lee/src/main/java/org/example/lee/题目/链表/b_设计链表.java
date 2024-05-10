package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class b_设计链表 {
 class MyLinkedList {
        public ListNode head;
        public ListNode tail;

        public MyLinkedList() {
        }

        public int get(int index) {
            int i = 0;
            ListNode node = head;
            while (i < index && node!=null) {
                node = node.next;
                i++;
            }
            if(node == null){
                return -1;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            int i = 0;
            ListNode node = head;
            while (i < index - 1 && node!=null) {
                node = node.next;
                i++;
            }
            if(node == null){
                return;
            }
            ListNode node1 = new ListNode(val);
            node1.next = node.next;
            node.next = node1;
            if(node1.next == null){
                tail = node1;
            }
        }

        public void deleteAtIndex(int index) {
            if (index == 0) {
                head = head.next;
                return;
            }
            int i = 0;
            ListNode node = head;
            while (i < index - 1 && node != null) {
                node = node.next;
                i++;
            }
            if (node == null || node.next == null) {
                return;
            }
            node.next = node.next.next;
            if (node.next == null) {
                tail = node;
            }
        }

    }
}
