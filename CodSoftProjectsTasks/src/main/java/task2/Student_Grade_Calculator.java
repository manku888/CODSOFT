package task2;

import java.util.Scanner;

public class Student_Grade_Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of subjects: ");
		int numOfSubjects = scanner.nextInt();

		int totalMarks = 0;
		for (int i = 1; i <= numOfSubjects; i++) {
			System.out.print("Enter marks obtained in subject " + i + ": ");
			int marks = scanner.nextInt();
			totalMarks += marks;
		}

		double averagePercentage = (double) totalMarks / numOfSubjects;

		System.out.println("\nTotal Marks: " + totalMarks);
		System.out.println("Average Percentage: " + averagePercentage + "%");

		String grade = calculateGrade(averagePercentage);
		if (averagePercentage >= 90) {
			System.out.println("outstanding , my dear Your grade is :" + grade);
		} else if (averagePercentage >= 80) {
			System.out.println("Excellent , my dear our grade is :" + grade);
		} else if (averagePercentage >= 70) {
			System.out.println("Good , my dear Your grade is :" + grade);
		} else if (averagePercentage >= 60) {
			System.out.println("Fair, my dear Your grade is :" + grade);
		} else if(averagePercentage >= 50) {

			System.out.println("Average , my dear Your grade is : " + grade);
		}
		else {
			System.out.println("Hey dear Student please do hard work : " + grade);
		}
		scanner.close();

	}

	public static String calculateGrade(double averagePercentage) {
		if (averagePercentage >= 90) {
			return "A++";
		} else if (averagePercentage >= 80) {
			return "A";
		} else if (averagePercentage >= 70) {
			return "B";
		} else if (averagePercentage >= 60) {
			return "C";
		} else if (averagePercentage >= 50) {
			return "D";
		} else {
			return "Fail";
		}
	}

}
