package 栈

import "container/list"

func isValid(s string) bool {
	l := list.New()
	m := make(map[byte]byte)
	m[')'] = '('
	m['}'] = '{'
	m[']'] = '['
	for _, iv := range s {
		v := byte(iv)
		if _, ok := m[v]; ok {
			if l.Len() == 0 || m[v] != l.Front().Value {
				return false
			}
			l.Remove(l.Front())
		} else {
			l.PushFront(v)
		}
	}
	return l.Len() == 0
}
