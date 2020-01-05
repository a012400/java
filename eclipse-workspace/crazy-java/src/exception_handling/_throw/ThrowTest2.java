package exception_handling._throw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThrowTest2 {
	public static void main(String[] args)
			// Java7 会检查此处可能抛出的异常的实际类型
			// 因此此处只需要抛出FileNotFoundException异常即可
			throws FileNotFoundException {
		try {
			new FileOutputStream("a.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
