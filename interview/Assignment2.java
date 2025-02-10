package interview;

public class Assignment2 {

	//Our program is to display 10 lab grades and the average lab grade, the course name
	public static void main(String[] args) {
		//course name
		String courseName = "Obejct Oriented Programming";
		//provide the 10 lab grades, hard code
		int[] labGrades = {20,20,18,19,17,19,20,20,20,19};
		//calculate the total sum of the grades
		int sum = 0;
		for(int grade : labGrades) {
			sum += grade;
		}
		// calculate the average
		double average = (double)sum/labGrades.length;
		//compile the code and print our results
		System.out.println(courseName);
		System.out.println("10 Lab grades: ");
		for(int grade : labGrades) {
			System.out.println(grade);
		}
		System.out.println("average lab grade : " + average);
	}
}
