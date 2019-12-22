package java_collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		Map map = new HashMap();
		// �ɹ�������key-value��
		map.put("���Java����", 109);
		map.put("���iOS����", 99);
		map.put("���Ajax����", 79);
		// �����滻keyΪ�����XML���塱��value������ԭMap��û�ж�Ӧ��key
		// ���Mapû�иı䣬��������µ�key-value��
		map.replace("���XML����", 66);
		System.out.println(map);
		// ʹ��ԭvalue�봫�������������Ľ������ԭ�е�value
		map.merge("���iOS����", 10, (oldVal, param) -> (Integer)oldVal + (Integer)param);
		System.out.println(map);
		// ��keyΪ��Java����Ӧ��valueΪnull���򲻴��ڣ�ʱ��ʹ�ü���Ľ����Ϊ�µ�value
		map.computeIfAbsent("Java", (key) -> ((String)key).length());
		System.out.println(map);
		// ��keyΪ��Java����Ӧ��value����ʱ��ʹ�ü���Ľ����Ϊ�µ�value
		map.computeIfPresent("Java", (key, value) -> (Integer)value * (Integer)value);
		System.out.println(map);
	}

}
