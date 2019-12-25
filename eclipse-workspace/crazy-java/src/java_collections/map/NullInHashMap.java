package java_collections.map;

import java.util.HashMap;

public class NullInHashMap {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		// 试图将两个key为null值的key-value对放入HashMap中
		hm.put(null, null);
		hm.put(null, null);
		// 将一个value为null值的key-value对放入HashMap中
		hm.put("a", null);
		System.out.println(hm);
	}

}
