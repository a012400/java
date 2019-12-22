package p191;

public class Course {
	private String name;
	private Integer score;

	public Course(String name, Integer score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == Course.class) {
			Course course = (Course) obj;
			if (this.name.equals(course.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public String toString() {
		return "Course[name: " + this.name + ", score: " + this.score + "]";
	}

}
