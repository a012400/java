package exception_handling._throw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThrowTest2 {
	public static void main(String[] args)
			// Java7 ����˴������׳����쳣��ʵ������
			// ��˴˴�ֻ��Ҫ�׳�FileNotFoundException�쳣����
			throws FileNotFoundException {
		try {
			new FileOutputStream("a.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
