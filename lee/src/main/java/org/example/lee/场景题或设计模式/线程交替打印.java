package org.example.lee.场景题或设计模式;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class 线程交替打印 {
	public static final Object lock = new Object();
	private static int count = 0;
	private static int MAX = 50;
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				while (count < MAX) {
					if (count % 2 == 0) {
						log.info("t1: {}", count);
						count++;
						lock.notify();
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				while (count < MAX) {
					if (count % 2 == 1) {
						log.info("t2: {}", count);
						count++;
						lock.notify();
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
    
}
