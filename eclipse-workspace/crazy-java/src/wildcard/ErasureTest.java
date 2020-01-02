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
		// a的getSize()方法返回Integer
		Integer as = a.getSize();
		// 把a对象赋给Milk变量，丢失尖括号里的类型信息
		Milk b = a;
		// b只知道size的类型是Number类
		Number size1 = b.getSize();
		// 下面代码引起编译错误
		// Integer size2 = b.getSize();
		
	}

}
