package java_collections.list;

import java.util.ArrayDeque;

public class ArrayDequeQueue {

	public static void main(String[] args) {
		ArrayDeque queue = new ArrayDeque();
		// 依次将三个元素加入队列
		queue.offer("疯狂Java讲义");
		queue.offer("轻量级Java EE企业应用实战");
		queue.offer("疯狂Android讲义");
		System.out.println(queue);
		// 访问队列头部的元素，但不将其poll出队列
		System.out.println(queue.peek());
		System.out.println(queue);
		// poll出第一个元素
		System.out.println(queue.poll());
		System.out.println(queue);
	}

}
