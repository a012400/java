package java_collections.list;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue qp = new PriorityQueue();
		// 下面代码依次向qp中加入四个元素
		qp.offer(6);
		qp.offer(-3);
		qp.offer(20);
		qp.offer(18);
		// 输出qp队列，并不是按元素的加入顺序排序
		System.out.println(qp);
		// 访问队列的第一个元素，其实就是队列中最小的元素
		System.out.println(qp.poll());
	}

}
