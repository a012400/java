package exception_handling.checked_runtime;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest2 {

	public static void main(String[] args) throws Exception {
		// ��Ϊtest()���������׳�IOException�쳣
		// ���Ե��ø÷����Ĵ���Ҫô����try...catch����
		// Ҫô������һ����throws�����׳��ķ�����
		test();
	}

	private static void test() throws IOException {
		// ��ΪFileInputStream�Ĺ����������׳�IOException�쳣
		// ���Ե���FIleInputStream�Ĵ���Ҫô����try...catch����
		// Ҫô������һ����throws�����׳��ķ�����
		FileInputStream fis = new FileInputStream("a.txt");
	}

}
