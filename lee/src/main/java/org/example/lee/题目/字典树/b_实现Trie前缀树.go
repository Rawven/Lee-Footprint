package 字典树

type Trie struct {
	root *Node
}

func Constructor() Trie {
	return Trie{root: NewNode()}
}

func (this *Trie) Insert(word string) {
	node := this.root
	for _, v := range word {
		if node.nodes[v-'a'] == nil {
			node.nodes[v-'a'] = NewNode()
		}
		node = node.nodes[v-'a']
	}
	node.canEnd = true
}

func (this *Trie) Search(word string) bool {
	tool, node := this.tool(word)
	return tool == true && node.canEnd == true
}

func (this *Trie) StartsWith(prefix string) bool {
	tool, _ := this.tool(prefix)
	return tool
}
func (this *Trie) tool(prefix string) (bool, *Node) {
	node := this.root
	for _, v := range prefix {
		if node.nodes[v-'a'] == nil {
			return false, node
		}
		node = node.nodes[v-'a']
	}
	return true, node
}
func NewNode() *Node {
	return &Node{
		nodes: make([]*Node, 26),
	}
}

type Node struct {
	nodes  []*Node
	canEnd bool
}
