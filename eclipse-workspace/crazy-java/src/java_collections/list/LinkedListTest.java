package java_collections.list;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		// 将字符串元素加入队列的尾部
		books.offer("疯狂Java讲义");
		// 讲一个字符串元素加入栈的顶部
		books.push("轻量级Java EE企业应用实战");
		// 将字符串元素添加到队列的头部(相当于栈的头部)
		books.offerFirst("疯狂Android讲义");
		// 以List的方式（按索引访问的方式）来遍历集合元素
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		// 访问不删除栈顶的元素
		System.out.println(books.peekFirst());
		// 访问不删除队列的最后一个元素
		System.out.println(books.peekLast());
		// 将栈顶的元素弹出栈
		System.out.println(books.pop());
		System.out.println(books);
		// 访问并删除队列的最后一个元素
		System.out.println(books.pollLast());
		System.out.println(books);
	}

}
