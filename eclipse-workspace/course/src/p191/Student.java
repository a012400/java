package p191;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String name;
	private Set<Course> courses;

	public Student(String name) {
		super();
		this.name = name;
		this.courses = new HashSet<Course>();
		this.courses.clear();
	}

	public String getName() {
		return name;
	}

	public Set<Course> getCourse() {
		return courses;
	}

	public void addCourse(Course c) {
		this.courses.add(c);
	}

	public boolean removeCourse(String name) {
		return this.courses.remove(new Course(name, 0));
	}

	public void show() {
		System.out.println(this.name + " Ñ¡¿Î: ");
		for (Course obj : this.courses) {
			System.out.println("\t" + obj.getName());
		}
	}
}
