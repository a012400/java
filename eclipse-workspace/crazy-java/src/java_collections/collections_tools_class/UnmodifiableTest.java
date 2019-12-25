package java_collections.collections_tools_class;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiableTest {

	public static void main(String[] args) {
		// ����һ���յġ����ɸı��List����
		List unmodifiableList = Collections.emptyList();
		// ����һ��ֻ��һ��Ԫ�أ��Ҳ��ɸı��Set����
		Set unmodifiableSet = Collections.singleton("���Java����");
		// ����һ����ͨ��Map����
		Map scores = new HashMap();
		scores.put("����", 80);
		scores.put("Java", 82);
		// ������ͨ��Map�����Ӧ�Ĳ��ɱ�汾
		Map unmodifiableMap = Collections.unmodifiableMap(scores);
		// ��������һ�ж�������UnsupportedOperationException�쳣
		unmodifiableList.add("����Ԫ��");
		unmodifiableSet.add("����Ԫ��");
		unmodifiableMap.put("����", 90);
	}

}
