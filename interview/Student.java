package interview;

public class Student {
	private String name;
	private String enrollDate;
	private String major;
	private String enrolledClass;
	private String completedClass;
	
	public Student() {};
	
	public Student(String name, String enrollDate, String major, String enrolledClass, String completedClass) {
		super();
		this.name = name;
		this.enrollDate = enrollDate;
		this.major = major;
		this.enrolledClass = enrolledClass;
		this.completedClass = completedClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEnrolledClass() {
		return enrolledClass;
	}

	public void setEnrolledClass(String enrolledClass) {
		this.enrolledClass = enrolledClass;
	}

	public String getCompletedClass() {
		return completedClass;
	}

	public void setCompletedClass(String completedClass) {
		this.completedClass = completedClass;
	}
	
	
	
}
