package java_collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap scores = new LinkedHashMap();
		scores.put("����", 80);
		scores.put("Ӣ��", 82);
		scores.put("��ѧ", 76);
		// ����forEach()��������scores�������key-value��
		scores.forEach((key, value) -> System.out.println(key + "-->" + value));
	}

}