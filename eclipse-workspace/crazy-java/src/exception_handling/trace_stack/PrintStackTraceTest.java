package exception_handling.trace_stack;

class SelException extends RuntimeException {
	SelException() {
	}

	SelException(String msg) {
		super(msg);
	}
}

public class PrintStackTraceTest {

	public static void main(String[] args) {
		firstMethod();
	}

	private static void firstMethod() {
		secondMethod();
	}

	private static void secondMethod() {
		thirdMethod();
	}

	private static void thirdMethod() {
		throw new SelException("自定义异常信息");
	}

}
