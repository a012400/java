package exception_handling.mechanism;

public class MultiExceptionTest {

	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您输入的两个数相除的结果是: " + c);
		} catch(IndexOutOfBoundsException | NumberFormatException | ArithmeticException ie) {
			System.out.println("程序发生了数组越界、数字格式异常、算术异常之一");
			// 捕获多异常时，异常变量默认有final修饰
			// 所以下面代码有错
			// ie = new ArithmeticException("test");
		}
	}

}
