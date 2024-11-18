package org.example.lee.场景题或设计模式;

public class MySingleton {

	public volatile static MySingleton instance;

	private MySingleton() {
	}

	public static MySingleton getInstance() {
		if (instance == null) {
			synchronized (MySingleton.class) {
				if (instance == null) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}
}
