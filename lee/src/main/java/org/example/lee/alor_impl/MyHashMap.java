package org.example.lee.alor_impl;

class MyHashMap<K, V> {
	int defaultSize = 10;
	double resizeCode = 0.75;
	int nowCapacity;
	int size;
	Entry[] arr;

	public MyHashMap() {
		size = 0;
		arr = new Entry[(int) defaultSize];
		nowCapacity = defaultSize;
	}

	int hash(K key) {
		return (int) (Math.abs(key.hashCode()) % nowCapacity);
	}

	public V get(K key) {
		int hash = hash(key);
		Entry entry = arr[hash];
		while (entry != null && !entry.key.equals(key)) {
			entry = entry.next;
		}
		return entry == null ? null : (V) entry.value;
	}

	synchronized public void put(K key, V value) {
		int hash = hash(key);
		if (arr[hash] == null) {
			arr[hash] = getEntry(key, value);
			size++;
		} else {
			Entry old = arr[hash];
			while (!old.key.equals(key) && old.next != null) {
				old = old.next;
			}
			if (old.key.equals(key)) {
				old.value = value;
			} else {
				old.next = getEntry(key, value);
				size++;
			}
		}
		checkToResize();
	}

	synchronized void checkToResize() {
		if (size > nowCapacity * resizeCode) {
			int capacity = nowCapacity * 2;
			Entry[] entries = new Entry[(int) capacity];
			for (Entry entry : arr) {
				while (entry != null) {
					int hash = hash((K) entry.key);
					Entry next = entry.next;
					entry.next = entries[hash];
					entries[hash] = entry;
					entry = next;
				}
			}
			nowCapacity = capacity;
			arr = entries;
		}
	}

	Entry getEntry(K key, V value) {
		return new Entry(key, value);
	}

	class Entry<K, V> {
		K key;
		V value;
		Entry next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	// 测试用例
	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		map.put("apple", 1);
		map.put("banana", 2);
		map.put("orange", 3);

		System.out.println("apple: " + map.get("apple"));   // 输出 apple: 1
		System.out.println("banana: " + map.get("banana")); // 输出 banana: 2
		System.out.println("mango: " + map.get("mango"));   // 输出 mango: null

		map.put("apple", 5); // 更新 apple 的值
		System.out.println("apple after update: " + map.get("apple")); // 输出 apple after update: 5

		// 插入更多元素，测试扩容
		for (int i = 4; i <= 20; i++) {
			map.put("key" + i, i);
		}
	}
}
