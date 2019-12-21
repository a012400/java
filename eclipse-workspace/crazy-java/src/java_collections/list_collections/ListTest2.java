package java_collections.list_collections;

import java.util.ArrayList;
import java.util.List;

class A {
	public boolean equals(Object obj) {
		return true;
	}
}

public class ListTest2 {

	public static void main(String[] args) {
		List books = new ArrayList();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂Android讲义"));
		books.add(new String("疯狂iOS讲义"));
		System.out.println(books);
		// 删除集合中的A对象，将导致第一个元素被删除
		books.remove(new A());
		System.out.println(books);
		// 删除集合中的A对象，再次删除集合中的第一个元素
		books.remove(new A());
		System.out.println(books);
	}

}
