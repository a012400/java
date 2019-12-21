package p191;

import java.util.HashSet;
import java.util.Set;

public class TestMain {

	public static void main(String[] args) {
		Course c1 = new Course("Mysql", 100);
		Course c2 = new Course("Mysql", 99);
		Course c3 = new Course("Java", 100);
		System.out.println(c1);
		System.out.println(c1.hashCode());
		System.out.println(c1.equals(c2));
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		Set hs = new HashSet();
		hs.add("asd");
		System.out.println(hs.remove("asdaads"));
		Student stu1 = new Student("fx");
		Student stu2 = new Student("fx2");
		stu1.addCourse(c1);
		stu1.addCourse(c2);
		stu1.addCourse(c3);
		stu2.addCourse(c1);
		stu2.addCourse(c2);
		stu2.addCourse(c3);
		stu1.show();
		SchoolClass sc = new SchoolClass("Javaѧϰ...");
		sc.addStudent(stu1);
		sc.addStudent(stu2);
		sc.show();
		System.out.println(sc.account());
	}

}
