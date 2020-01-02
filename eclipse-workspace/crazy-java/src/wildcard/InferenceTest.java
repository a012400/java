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
		// 可以通过方法赋值的目标参数来推断泛型为String
		MyUtil<String> ls = MyUtil.nil();
		// 无须使用下面语句在调用nil()方法时指定泛型的类型
		MyUtil<String> mu = MyUtil.<String>nil();

		// 可调用cons()方法所需的参数类型来推断泛型为Integer
		MyUtil.cons(42, MyUtil.nil());
		// 无须使用下面语句在调用nil()方法时指定泛型的类型
		MyUtil.cons(42, MyUtil.<Integer>nil());
		
		String s = MyUtil.<String>nil().head();
	}

}
