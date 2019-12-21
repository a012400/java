package p191;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SchoolClass {
	private String name;
	private Set<Student> students;

	public SchoolClass(String name) {
		super();
		this.name = name;
		this.students = new HashSet<Student>();
		this.students.clear();
	}

	public void addStudent(Student s) {
		this.students.add(s);
	}

	public boolean removeStudent(String name) {
		return this.students.remove(new Student(name));
	}

	public void show() {
		System.out.println(this.name);
		for (Student stu : students) {
			stu.show();
		}
	}

	public Map<Course, Integer> account() {
		Map<Course, Integer> map = new HashMap<Course, Integer>();
		map.clear();
		List<Course> list = new ArrayList<Course>();
		Set<Course> set = new HashSet<Course>();
		for (Student stu : students) {
			set.addAll(stu.getCourse());
			list.addAll(stu.getCourse());
		}
		for (Course course : set) {
			map.put(course, Collections.frequency(list, course));
		}
		return map;
	}
}
