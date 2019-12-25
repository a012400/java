package java_collections.map;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapErrorTest {

	public static void main(String[] args) {
		HashMap ht = new HashMap();
		// �˴�A����ǰһ�������A����ͬһ����
		ht.put(new A(60000), "���Java����");
		ht.put(new A(87563), "������Java EE��ҵӦ��ʵս");
		System.out.println(ht);
		// ���Hashtable��key Set���϶�Ӧ��Iterator������
		Iterator it = ht.keySet().iterator();
		// ȡ��Map�е�һ��key�����޸�����countֵ
		A first = (A)it.next();
		first.count = 87563;
		System.out.println(ht);
		// ֻ��ɾ��û�б��޸Ĺ���key����Ӧ��key-value��
		ht.remove(new A(87563));
		System.out.println(ht);
		// �޷���ȡʣ�µ�value
		System.out.println(ht.get(new A(87563)));
		System.out.println(ht.get(new A(6000)));
	}

}
