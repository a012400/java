package wildcard;

class MyUtil<E> {

	public static <Z> MyUtil<Z> nil() {
		return null;
	}

	public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail) {
		return null;
	}

	E head() {
		return null;
	}
}

public class InferenceTest {

	public static void main(String[] args) {
		// ����ͨ��������ֵ��Ŀ��������ƶϷ���ΪString
		MyUtil<String> ls = MyUtil.nil();
		// ����ʹ����������ڵ���nil()����ʱָ�����͵�����
		MyUtil<String> mu = MyUtil.<String>nil();

		// �ɵ���cons()��������Ĳ����������ƶϷ���ΪInteger
		MyUtil.cons(42, MyUtil.nil());
		// ����ʹ����������ڵ���nil()����ʱָ�����͵�����
		MyUtil.cons(42, MyUtil.<Integer>nil());
		
		String s = MyUtil.<String>nil().head();
	}

}
