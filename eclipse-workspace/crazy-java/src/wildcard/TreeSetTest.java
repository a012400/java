package wildcard;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		// Comparator��ʵ��������TreeSet��Ԫ�����͵ĸ��࣬����Ҫ��
		TreeSet<String> ts1 = new TreeSet<>(new Comparator<>() {
			public int compare(String fst, String snd) {
				return hashCode() > snd.hashCode() ? 1 : hashCode() < snd.hashCode() ? -1 : 0;
			}
		});
		ts1.add("hello");
		ts1.add("wa");
		// Comparator��ʵ��������TreeSetԪ�ص����� ����Ҫ��
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
			public int compare(String first, String second) {
				return first.length() > second.length() ? -1 : first.length() < second.length() ? 1 : 0;
			}
		});
		ts2.add("hello");
		ts2.add("wa");
		System.out.println(ts1);
		System.out.println(ts2);
	}
}