package p83;

public class PointTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(6);
		Point p2 = new Point(3, 4);
		System.out.println("(6, 6)�㵽(3, 4)�����Ϊ: " + p1.distance(p2));
		System.out.println("(3, 4)�㵽(9, 22)��ľ���Ϊ: " + p2.distance(9, 22));
		Circle c1 = new Circle(9, 22, 6.66);
		System.out.println("Բ����(9, 22)�뾶Ϊ6.66Բ�����Ϊ: " + c1.getArea());
		System.out.println("Բ����(9, 22)�뾶Ϊ6.66Բ�Ƿ����(3, 4)��: " + c1.contains(p2));
		System.out.println("Բ����(9, 22)�뾶Ϊ6.66Բ�Ƿ����(9, 16)��: " + c1.contains(9, 16));
		
	}

}
