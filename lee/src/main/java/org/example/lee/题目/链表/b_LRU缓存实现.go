package 链表

// 不使用api
type LRUCache struct {
	m          map[int]*Element
	ca         int
	head, tail *Element
}
type Element struct {
	front, prev *Element
	key, value  int
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		ca:   capacity,
		m:    make(map[int]*Element),
		head: nil,
		tail: nil,
	}
}

func (this *LRUCache) Get(key int) int {
	if v, ok := this.m[key]; ok {
		this.toTop(v)
		return v.value
	}
	//找不到
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if v, ok := this.m[key]; ok {
		this.toTop(v)
		v.value = value
		return
	}
	e := &Element{
		front: nil,
		prev:  nil,
		key:   key,
		value: value,
	}
	//初始化头尾
	if len(this.m) == 0 {
		this.head, this.tail = e, e
	}
	this.toTop(e)
	this.m[key] = e
	//超出容量
	if len(this.m) > this.ca {
		this.deleteTail()
	}
}

func (this *LRUCache) deleteTail() {
	delete(this.m, this.tail.key)
	//新tail形成
	a := this.tail.front
	this.tail = a
	this.tail.prev = nil
}
func (this *LRUCache) toTop(v *Element) {
	if v == this.head {
		//已经是头结点
		return
	}
	//前后结点连接
	a, b := v.prev, v.front
	if v == this.tail {
		this.tail = b
	}
	if a != nil {
		a.front = b
	}
	if b != nil {
		b.prev = a
	}
	//头结点列举
	this.head.front = v
	v.prev, v.front = this.head, nil
	this.head = v
}

// 哈希表+双向链表  使用了api
//type LRUCache struct {
//	l  *list.List
//	m  map[int]*list.Element
//	ca int
//}
//type Entry struct {
//	key   int
//	value int
//}
//
//func Constructor(capacity int) LRUCache {
//	return LRUCache{
//		l:  list.New(),
//		m:  make(map[int]*list.Element),
//		ca: capacity,
//	}
//}
//
//func (this *LRUCache) Get(key int) int {
//	v, ok := this.m[key]
//	if !ok {
//		return -1
//	}
//	this.l.MoveToFront(v)
//	return v.Value.(*Entry).value
//}
//
//func (this *LRUCache) Put(key int, value int) {
//	v, ok := this.m[key]
//	if ok {
//		//存在 则更新值
//		v.Value.(*Entry).value = value
//		this.l.MoveToFront(this.m[key])
//		return
//	}
//	//不存在 插入头部
//	e := this.l.PushFront(&Entry{
//		key:   key,
//		value: value,
//	})
//	this.m[key] = e
//	//溢出则删除尾部
//	if this.l.Len() > this.ca {
//		back := this.l.Back()
//		delete(this.m, back.Value.(*Entry).key)
//		this.l.Remove(back)
//	}
//}
