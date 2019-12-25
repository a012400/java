package java_collections.map;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapErrorTest {

	public static void main(String[] args) {
		HashMap ht = new HashMap();
		// 此处A类与前一个程序的A类是同一个类
		ht.put(new A(60000), "疯狂Java讲义");
		ht.put(new A(87563), "轻量级Java EE企业应用实战");
		System.out.println(ht);
		// 获得Hashtable的key Set集合对应的Iterator迭代器
		Iterator it = ht.keySet().iterator();
		// 取出Map中第一个key，并修改它的count值
		A first = (A)it.next();
		first.count = 87563;
		System.out.println(ht);
		// 只能删除没有被修改过的key所对应的key-value对
		ht.remove(new A(87563));
		System.out.println(ht);
		// 无法获取剩下的value
		System.out.println(ht.get(new A(87563)));
		System.out.println(ht.get(new A(6000)));
	}

}
