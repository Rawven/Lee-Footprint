package main

import (
	_ "container/list"
	"strconv"
	"sync"
)

var (
	count = 0
	max   = 50
	lock  = sync.Mutex{}
	cond  = sync.NewCond(&lock)
)

func main12() {
	go func() {
		for count < max {
			lock.Lock()
			for count%2 == 0 {
				cond.Wait()
			}
			println("First:" + strconv.Itoa(count))
			count++
			cond.Signal()
			lock.Unlock()
		}
	}()

	go func() {
		for count < max {
			lock.Lock()
			for count%2 != 0 {
				cond.Wait()
			}
			println("Second:" + strconv.Itoa(count))
			count++
			cond.Signal()
			lock.Unlock()
		}
	}()
	select {}
}
