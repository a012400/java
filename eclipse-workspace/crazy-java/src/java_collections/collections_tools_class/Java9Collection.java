package java_collections.collections_tools_class;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9Collection {

	public static void main(String[] args) {
		// ��������4��Ԫ�ص�Set����
		Set set = Set.of("Java", "Kotlin", "Go", "Swift");
		System.out.println(set);
		// ���ɱ伯�� ���漯�ϵ�������ʱ����
		// set.add("Ruby");
		
		// ��������4��Ԫ�ص�List����
		List list = List.of(34, -25, 67, 231);
		System.out.println(list);
		// ���ɱ伯�� ���漯�ϵ�������ʱ����
		// list.remove(1);
		
		// ��������3��Ԫ�ص�Map����
		Map map = Map.of("����", 89, "��ѧ", 82, "Ӣ��", 92);
		System.out.println(map);
		// ���ɱ伯�� ���漯�ϵ�������ʱ����
		// map.remove("����");
		
		// ʹ��Map.entry()������ʽ����key-value��
		Map map2 = Map.ofEntries(Map.entry("����", 89),
				Map.entry("��ѧ", 82),
				Map.entry("Ӣ��", 92));
		System.out.println(map2);
	}

}
