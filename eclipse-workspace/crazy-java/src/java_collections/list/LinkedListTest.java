package java_collections.list;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		// ���ַ���Ԫ�ؼ�����е�β��
		books.offer("���Java����");
		// ��һ���ַ���Ԫ�ؼ���ջ�Ķ���
		books.push("������Java EE��ҵӦ��ʵս");
		// ���ַ���Ԫ����ӵ����е�ͷ��(�൱��ջ��ͷ��)
		books.offerFirst("���Android����");
		// ��List�ķ�ʽ�����������ʵķ�ʽ������������Ԫ��
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		// ���ʲ�ɾ��ջ����Ԫ��
		System.out.println(books.peekFirst());
		// ���ʲ�ɾ�����е����һ��Ԫ��
		System.out.println(books.peekLast());
		// ��ջ����Ԫ�ص���ջ
		System.out.println(books.pop());
		System.out.println(books);
		// ���ʲ�ɾ�����е����һ��Ԫ��
		System.out.println(books.pollLast());
		System.out.println(books);
	}

}
