package wildcard;

class Milk<T extends Number> {
	T size;

	public Milk() {
	}

	public Milk(T size) {
		this.size = size;
	}

	public T getSize() {
		return size;
	}

	public void setSize(T size) {
		this.size = size;
	}

}

public class ErasureTest {

	public static void main(String[] args) {
		Milk<Integer> a = new Milk<>(6);
		// a��getSize()��������Integer
		Integer as = a.getSize();
		// ��a���󸳸�Milk��������ʧ���������������Ϣ
		Milk b = a;
		// bֻ֪��size��������Number��
		Number size1 = b.getSize();
		// �����������������
		// Integer size2 = b.getSize();
		
	}

}
