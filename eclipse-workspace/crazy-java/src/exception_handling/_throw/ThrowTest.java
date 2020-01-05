package exception_handling._throw;

public class ThrowTest {

	public static void main(String[] args) {
		try {
			// 调用声明抛出Checked异常的方法，要么显式捕获该异常
			// 要么在main方法中再次声明抛出
			throwChecked(3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void throwChecked(int a) throws Exception {
		if (a > 0) {
			// 自行抛出Exception异常
			// 该代码必须处于try块里或处于带throws声明的方法中
			throw new Exception("a的值大于0,不符合要求");
		}
	}

}
