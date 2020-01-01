package wildcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUtils {

	// ����dest����Ԫ�ص����ͱ�����src����Ԫ�ص�������ͬ���������丸��
	public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
		T last = null;
		for (T ele : src) {
			last = ele;
			// ���ķ��ͼ������Ԫ���ǰ�ȫ��
			dest.add(ele);
		}
		return last;
	}

	public static void main(String[] args) {
		List<Number> ln = new ArrayList<>();
		List<Integer> li = new ArrayList<>();
		li.add(5);
		// �˴���׼ȷ��֪�����һ�������Ƶ�Ԫ����Integer����
		// ��src����Ԫ�ص�������ͬ
		Integer last = copy(ln, li);
		System.out.println(ln);
	}

}
