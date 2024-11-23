package main

import (
	"fmt"
	"math/rand"
	"time"
)

type Event struct {
	name string
}

func Consumer(c chan Event, name string) {
	for {
		event := <-c
		fmt.Println(name + "号消费者消费事件" + event.name)
	}
}

func Producer(c chan Event, name string) {
	for {
		time.Sleep(time.Duration(rand.Intn(3)+1) * time.Second) // 随机等待时间模拟生产时间
		fmt.Println(name + "号生产者生成事件")
		c <- Event{name: time.Now().String()}
	}
}

func main() {
	channel := make(chan Event, 50)
	go Producer(channel, "1")
	go Producer(channel, "2")
	go Producer(channel, "3")
	go Consumer(channel, "1")
	go Consumer(channel, "2")
	go Consumer(channel, "3")
	select {}
}
