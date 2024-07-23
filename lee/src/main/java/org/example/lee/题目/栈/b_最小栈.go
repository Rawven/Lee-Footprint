package 栈

// 常数时间内检索最小元素
type MinStack struct {
	main []int
	help []int
}

func Constructor() MinStack {
	return MinStack{
		main: []int{},
		help: []int{},
	}
}

func (this *MinStack) Push(val int) {
	this.main = append(this.main, val)
	if len(this.help) == 0 || this.help[len(this.help)-1] >= val {
		this.help = append(this.help, val)
	} else {
		this.help = append(this.help, this.help[len(this.help)-1])
	}
}

func (this *MinStack) Pop() {
	this.main = this.main[:len(this.main)-1]
	this.help = this.help[:len(this.help)-1]
}

func (this *MinStack) Top() int {
	return this.main[len(this.main)-1]
}

func (this *MinStack) GetMin() int {
	return this.help[len(this.help)-1]
}
