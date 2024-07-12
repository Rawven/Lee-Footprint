package org.example.lee.题目.链表;

import java.util.HashMap;

/**
 * b lru缓存实现
 *
 * @author 刘家辉
 * @date 2024/01/26
 */
public class b_LRU缓存实现 {

  /**
   * lrucache LRU缓存机制，即采用最近最少使用的缓存策略。它的原则是，如果一个数据最近没有被访问到， 么它将来被访问的几率也很小，
   * 也就是说当限定的内存空间已没有其他空间可用时，应该把最久没有访问到的数据去除掉。
   *
   * @author 刘家辉
   * @date 2024/01/26
   */
  class LRUCache {

    int capacity;
    int size;
    TwoListNode head;
    TwoListNode tail;
    private HashMap<Integer, TwoListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
      this.capacity = capacity;
      head = new TwoListNode(-1, -1);
      tail = new TwoListNode(-2, -2);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      TwoListNode node = map.get(key);
      if (node != null) {
        TwoListNode q, p;
        if (size != 1) {
          deleteTail(node);
          addHead(node);
        }
        return node.value;
      }
      return -1;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        TwoListNode twoListNode = map.get(key);
        twoListNode.value = value;
        deleteTail(twoListNode);
        addHead(twoListNode);
        map.put(key, twoListNode);
      } else {
        TwoListNode newNode = new TwoListNode(key, value);
        addHead(newNode);
        map.put(key, newNode);
        if (size + 1 > capacity) {
          TwoListNode prev = tail.prev;
          deleteTail(tail.prev);
          map.remove(prev.key);
        } else {
          size++;
        }
      }

    }

    public void addHead(TwoListNode node) {
      TwoListNode headNext = head.next;
      head.next = node;
      node.prev = head;
      headNext.prev = node;
      node.next = headNext;
    }

    public void deleteTail(TwoListNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    class TwoListNode {

      int key;
      int value;
      TwoListNode prev;
      TwoListNode next;

      public TwoListNode() {
      }

      public TwoListNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }
}
