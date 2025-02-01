package interview;

public class Assignment1 {

	public static void main(String[] args) {
		Student student = new Student("Chang Che","Feb-12,2024",
				"Information Studies","Advanced Database","Data Science");
		
		System.out.println("Student's name is " + student.getName());
		System.out.println("Student's enroll date is " + student.getEnrollDate());
		System.out.println("Student's major is " + student.getMajor());
		System.out.println("One class the student is currently enrolled in " + student.getEnrolledClass());
		System.out.println("One completed class is " + student.getCompletedClass());
	}
	
}
