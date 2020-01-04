package exception_handling.mechanism;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoCloseTest2 {

	public static void main(String[] args) throws IOException {
		// ��final���ε���Դ
		final BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
		// û����ʽʹ��final���Σ���ֻҪ���Ըñ������¸�ֵ���ñ���������Ч��final
		PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
		// ֻҪ��������Դ����try���Բ�����ڼ���
		try (br; ps) {
			// ʹ��������Դ
			System.out.println(br.readLine());
			ps.println("ׯ�������Ժ���");
		}
	}

}
