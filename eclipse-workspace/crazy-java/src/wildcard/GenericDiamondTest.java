package wildcard;

class MyClass<E> {
	public <T> MyClass(T t) {
		System.out.println("t����ֵΪ: " + t);
	}
}

public class GenericDiamondTest {

	public static void main(String[] args) {
		// MyClass�������е�E�β���String����
		// ���͹�������������T�β���Integer����
		MyClass<String> mc1 = new MyClass<>(9);
		// ��ʽָ�����͹�������������T�β���Integer����
		MyClass<String> mc2 = new <Integer>MyClass<String>(9);
		// MyClass��������E�β���String����
		// �����ʽָ�����͹�������������T�β���Integer����
		// ��ʱ�Ͳ���ʹ�������﷨ ��������Ǵ��
		// MyClass<String> mc3 = new <Integer>MyClass<>(9);
	}

}
