package util;

import entities.Course;
import entities.Student;
import entities.CourseGrades;

public  class AddStudentCourse {
	
	public static void addStudentCourse(Student student, Course course, int courseID, Double firstGrade, Double secondGrade) {
		student.addCourse(new CourseGrades(course)); 
		student.getCourseGrades(courseID).addGrade(firstGrade);
		student.getCourseGrades(courseID).addGrade(secondGrade);
		course.addStudent(student);
	}

}
