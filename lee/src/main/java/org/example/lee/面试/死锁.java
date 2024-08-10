package org.example.lee.面试;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("all")
public class 死锁 {

  public static final Object a = new Object();
  public static final Object b = new Object();

  public static void main(String[] args) {

    new Thread(() -> {
      synchronized (a) {
        log.info("我现在占有着 a");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          log.info("报错");
        }
        synchronized (b) {
          log.info("来点b");
        }
      }
    }, "线程甲").start();
    new Thread(() -> {
      synchronized (b) {
        log.info("我现在占有着 b");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          log.info("报错");
        }

        synchronized (a) {
          log.info("来点a");
        }
      }
    }, "线程乙").start();

  }

}
