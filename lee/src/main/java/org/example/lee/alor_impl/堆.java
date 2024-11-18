package org.example.lee.alor_impl;

import java.util.ArrayList;
import java.util.List;

public class 堆 {

	protected List<Integer> maxHeap = new ArrayList<>();
	/*堆的实现 大顶堆 （倒置运算符则为小根堆）
	 * “二叉树”章节讲过，完全二叉树非常适合用数组来表示。
	 * 由于堆正是一种完全二叉树，因此我们将采用数组来存储堆。
	 * 当使用数组表示二叉树时，元素代表节点值，
	 * 索引代表节点在二叉树中的位置。节点指针通过索引映射公式来实现。
	 * 如图 8-2 所示，给定索引
	 *  ，其左子节点索引为2i+1
	 *  ，右子节点索引为 2i+2
	 *  ，父节点索引为(i-1)/2
	 * （向下整除）。当索引越界时，表示空节点或节点不存在。
	 */
    class MyHeap {
        List<Integer> list = new ArrayList<>();

        public MyHeap() {

        }

        private int left(int index) {
            return 2 * index + 1;
        }

        private int right(int index) {
            return 2 * index + 2;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private void swap(int i1, int i2) {
            int v1 = list.get(i1);
            list.set(i1,list.get(i2));
            list.set(i2,v1);
        }

        private void upToDown(int index) {
            while (true) {
                int l = left(index), r = right(index), h = index;
                if (l < list.size() && list.get(l) > list.get(h)) {
                    h = l;
                }
                if (r < list.size() && list.get(r) > list.get(h)) {
                    h = r;
                }
                if (h == index) {
                    break;
                }
                swap(index,h);
                index = h;
            }
        }

        private void downToUp(int index){
            while(true){
                int p = parent(index) , h = index;
                if(p >= 0 && list.get(p) < list.get(h)){
                     h = p ;
                }
                if(h == index){
                    break;
                }
                swap(index,h);
                index = h;
            }
        }

		/**
		 * 弹出 
		 * 先将顶部与尾部替换,然后再自顶向下递归调整
		 */
		public int pop() {
            int value = list.get(0);
            swap(0, list.size() - 1);
            list.remove(list.size() - 1);
            upToDown(0);
            return value;
        }

        public int peek() {
            return list.get(0);
        }

		/**
		 * 加入
		 * 直接从尾部自底向上调整
		 */
		public void add(int value) {
            list.add(value);
            downToUp(list.size()-1);
        }

    }


}
