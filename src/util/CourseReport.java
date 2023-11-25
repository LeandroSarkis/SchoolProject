package util;

import entities.Course;
import entities.Student;

public class CourseReport {

	public static void generateReport(Course course) {

		System.out.println("Course name: " + course.getName() + "\nAll students: \n\n"
				+ allStudentsNamesAndGrades(course) + "************************************\n"
				+ "The average of all students is: " + allStudentAVG(course)+ "\n\n************************************\n"
				+ "The standard deviant of all students is: " + allStudentStandardDeviation(course));

	}

	public static String allStudentsNamesAndGrades(Course course) {

		String allNamesAndGrades = "";

		for (Student student : course.getStudents()) {
			allNamesAndGrades += "Student: " + student.getName() + " \ngrade 1: "
					+ student.getCourseGrades(course.getCourseID()).getFirstGrade() + " \ngrade 2: "
					+ student.getCourseGrades(course.getCourseID()).getSecondGrade() + "\n\n";
		}

		return allNamesAndGrades;
	}

	public static double allStudentAVG(Course course) {
		double avg = 0.0, sum = 0.0;

		for (Student student : course.getStudents()) {
			sum += student.getCourseGrades(course.getCourseID()).getFirstGrade()
					+ student.getCourseGrades(course.getCourseID()).getSecondGrade();
		}

		avg = sum / (course.getStudents().size() * 2);
		return avg;
	}

	public static double allStudentStandardDeviation(Course course) {
		double avg = allStudentAVG(course);
		double sum = 0;

		for (Student student : course.getStudents()) {
			sum += Math.pow((student.getCourseGrades(course.getCourseID()).getFirstGrade() - avg), 2)
					+ Math.pow((student.getCourseGrades(course.getCourseID()).getSecondGrade() - avg), 2);
		}
		
		return Math.sqrt(sum / (course.getStudents().size()*2));
	}

}
