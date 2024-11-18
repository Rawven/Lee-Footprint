package org.example.lee.题目.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * b lru缓存实现
 *
 * @author 刘家辉
 * @date 2024/01/26
 */
public class b_LRU缓存实现 {
	@SuppressWarnings("all")
	class LRUCache {
		int capacity;
		int nowCapacity;
		//虚拟头尾结点用于辅助
		Element head;
		Element end;
		Map<Integer, Element> map = new HashMap<>();

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.nowCapacity = 0;
			head = new Element();
			end = new Element();
			head.next = end;
			end.prev = head;
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			toHead(map.get(key));
			return map.get(key).value;
		}

		public void put(int key, int value) {
			Element element;
			if (!map.containsKey(key)) {
				element = new Element(key, value);
				map.put(key, element);
				if (nowCapacity == capacity) {
					removeEnd();
				} else {
					nowCapacity++;
				}
			} else {
				element = map.get(key);
				element.value = value;
			}
			toHead(element);
		}

		public void toHead(Element element) {
			moveElementIfInList(element);
			
			head.next.prev = element;
			element.next = head.next;
			element.prev = head;
			head.next = element;
		}

		public void removeEnd() {
			Element rEnd = end.prev;
			map.remove(rEnd.key);
			moveElementIfInList(rEnd);
		}

		public void moveElementIfInList(Element element) {
			// 如果元素已经在链表中，先移除它
			if (element.prev != null && element.next != null) {
				element.prev.next = element.next;
				element.next.prev = element.prev;
			}
		}
	}

	class Element {
		public Element prev;
		public Element next;
		public int key;
		public int value;

		public Element() {
		}

		public Element(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
