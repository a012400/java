package exception_handling._throw;

public class ThrowTest {

	public static void main(String[] args) {
		try {
			// ���������׳�Checked�쳣�ķ�����Ҫô��ʽ������쳣
			// Ҫô��main�������ٴ������׳�
			throwChecked(3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void throwChecked(int a) throws Exception {
		if (a > 0) {
			// �����׳�Exception�쳣
			// �ô�����봦��try������ڴ�throws�����ķ�����
			throw new Exception("a��ֵ����0,������Ҫ��");
		}
	}

}
