package p191;

import java.util.Scanner;

public class TestSchool {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SchoolClass school = new SchoolClass("Javaѧϰ...");
		Student student = null;
		Course course = null;
		String stuName = null;
		String courseName = null;
		while (true) {
			System.out.print("����ѧ��������: ");
			stuName = scn.next();
			if (stuName.equalsIgnoreCase("quit")) {
				break;
			}
			student = new Student(stuName);
			while (true) {
				System.out.print("����γ�, quit����: ");
				courseName = scn.next();
				if (courseName.equalsIgnoreCase("quit")) {
					break;
				}
				course = new Course(courseName, null);
				student.addCourse(course);
			} // while: ���ѧ���γ�
			school.addStudent(student);
		} // for: ���ѧ��
		scn.close();
		school.show();
	}

}
