package wildcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErrorTest {
	// ����һ�����ͷ������÷��ͷ����д�һ��T�����β�
	static <T> void test(Collection<T> from, Collection<T> to) {
		for (T ele : from) {
			to.add(ele);
		}
	}

	public static void main(String[] args) {
		List<Object> ao = new ArrayList<>();
		List<String> as = new ArrayList<>();
		// ������뽫�����������
		// test(as, ao);
	}

}