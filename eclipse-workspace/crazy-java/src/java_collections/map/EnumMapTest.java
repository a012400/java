package java_collections.map;

import java.util.EnumMap;

enum Season {
	SPRING, SUMER, FALL, WINTER
}

public class EnumMapTest {

	public static void main(String[] args) {
		// ����EnumMap���󣬸�EnumMap������key����Seasonö�����ö��ֵ
		EnumMap enumMap = new EnumMap(Season.class);
		enumMap.put(Season.SUMER, "��������");
		enumMap.put(Season.SPRING, "��ů����");
		System.out.println(enumMap);
	}

}
