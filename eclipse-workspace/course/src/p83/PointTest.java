package p83;

public class PointTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(6);
		Point p2 = new Point(3, 4);
		System.out.println("(6, 6)点到(3, 4)点距离为: " + p1.distance(p2));
		System.out.println("(3, 4)点到(9, 22)点的距离为: " + p2.distance(9, 22));
		Circle c1 = new Circle(9, 22, 6.66);
		System.out.println("圆心在(9, 22)半径为6.66圆的面积为: " + c1.getArea());
		System.out.println("圆心在(9, 22)半径为6.66圆是否包含(3, 4)点: " + c1.contains(p2));
		System.out.println("圆心在(9, 22)半径为6.66圆是否包含(9, 16)点: " + c1.contains(9, 16));
		
	}

}
