package p191;

import java.util.Scanner;

public class TestSchool {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SchoolClass school = new SchoolClass("Java学习...");
		Student student = null;
		Course course = null;
		String stuName = null;
		String courseName = null;
		while (true) {
			System.out.print("输入学生的姓名: ");
			stuName = scn.next();
			if (stuName.equalsIgnoreCase("quit")) {
				break;
			}
			student = new Student(stuName);
			while (true) {
				System.out.print("输入课程, quit结束: ");
				courseName = scn.next();
				if (courseName.equalsIgnoreCase("quit")) {
					break;
				}
				course = new Course(courseName, null);
				student.addCourse(course);
			} // while: 添加学生课程
			school.addStudent(student);
		} // for: 添加学生
		scn.close();
		school.show();
	}

}
