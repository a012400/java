package generic.thorough;

public class A1 extends Apple<String> {

	// ��ȷ��д�˸��෽�� ����ֵ�븸��Apple<String>�ķ���ֵ��ȫ��ͬ
	public String getInfo() {
		return "����" + super.getInfo();
	}

	/*
	 * ���淽���Ǵ���ģ���д����ʱ����ֵ���Ͳ�һ�� public Object getInfo() 
	 * { 
	 * return "����"; 
	 * }
	 */

}
