package java_collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("语文", 80);
		scores.put("英文", 82);
		scores.put("数学", 76);
		// 调用forEach()方法遍历scores里的所有key-value对
		scores.forEach((key, value) -> System.out.println(key + "-->" + value));
	}

}
