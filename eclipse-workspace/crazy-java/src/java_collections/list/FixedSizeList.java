package java_collections.list;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {

	public static void main(String[] args) {
		List fixedList = Arrays.asList("���Java����", "������Java EE��ҵӦ��ʵս");
		// ��ȡfixedList��ʵ���࣬����� Array$ArrayList
		System.out.println(fixedList.getClass());
		// ʹ�÷������ñ�������Ԫ��
		fixedList.forEach(System.out :: println);
		// ��ͼ���ӡ�ɾ��Ԫ�ض������� UnsupportedOperationException �쳣
		fixedList.add("���Android����");
		fixedList.remove("���Java����");
	}

}
