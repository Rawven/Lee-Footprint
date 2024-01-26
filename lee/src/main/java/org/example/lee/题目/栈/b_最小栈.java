package org.example.lee.题目.栈;

import java.util.Stack;

public class b_最小栈 {

    /**
     * min stack 压栈逻辑
     * https://leetcode.cn/problems/min-stack/solutions/674293/tu-li-zhan-shi-shuang-zhan-shi-xian-zui-fcwj5/?envType=study-plan-v2&envId=top-interview-150
     *
     * @author 刘家辉
     * @date 2024/01/17
     */
    class MinStack {
        private Stack<Integer> data;

        private Stack<Integer> help;

        public MinStack() {
            data = new Stack<>();
            help = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (help.isEmpty() || val <= help.peek()) {
                help.push(val);
            } else {
                help.push(help.peek());
            }

        }

        public void pop() {
            data.pop();
            help.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return help.peek();
        }
    }
}
