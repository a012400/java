package exception_handling.mechanism;

public class FinallyFlowTest {

	public static void main(String[] args) throws Exception {
		boolean a = test();
		System.out.println(a);
	}

	private static boolean test() {
		try {
			// ��Ϊfinally���а�����return���
			// ���������return���ʧȥ����
			return true;
		} finally {
			return false;
		}
	}

}
