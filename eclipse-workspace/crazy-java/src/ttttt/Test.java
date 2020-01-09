package ttttt;

class Father {
	private int age;
	protected double weight;
	public String name;
	
	public Father() {}
	
	public Father(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	private void eat() {
		System.out.println("---eat---");
	}
	
	public void sleep() {
		System.out.println("---sleep---");
	}
}

public class Test extends Father{
	
	public Test() {
		super(16, "fx");
	}
	public static void main(String[] args) {
		Test tt = new Test();
		tt.weight = 180.00;
		tt.sleep();
		tt.name = "fx";
	}
}
