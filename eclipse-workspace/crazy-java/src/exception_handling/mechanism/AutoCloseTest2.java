package exception_handling.mechanism;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoCloseTest2 {

	public static void main(String[] args) throws IOException {
		// 有final修饰的资源
		final BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
		// 没有显式使用final修饰，但只要不对该变量重新赋值，该变量就是有效的final
		PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
		// 只要将两个资源放在try后的圆括号内即可
		try (br; ps) {
			// 使用两个资源
			System.out.println(br.readLine());
			ps.println("庄生晓梦迷蝴蝶");
		}
	}

}
