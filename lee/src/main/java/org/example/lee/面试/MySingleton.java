package org.example.lee.面试;

public class MySingleton {

  public volatile static MySingleton instance;

  private MySingleton() {
  }

  public static MySingleton getInstance() {
    if (instance == null) {
      synchronized (MySingleton.instance) {
        if (instance == null) {
          instance = new MySingleton();
        }
      }
    }
    return instance;
  }
}
