package generic.threshold;

import java.util.ArrayList;
import java.util.List;

public class ListErr {

	public static void main(String[] args) {
		// ����һ��ֻ�뱣���ַ�����List����
		List strList = new ArrayList();
		strList.add("ʮ�꺮��������");
		strList.add("��ʹ���Ӧ��ʶ");
		// "��С��"��һ��Integer����"����"�˼���
		strList.add(5);
		strList.forEach(str -> System.out.println(((String) str).length()));
	}

}
