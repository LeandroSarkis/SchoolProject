package util;

import entities.Course;
import entities.Student;
import entities.CourseGrades;

public  class AddStudentCourse {
	
	public static void addStudentCourse(Student student, Course course, Double firstGrade, Double secondGrade) {
		student.addCourse(new CourseGrades(course)); 
		student.getCourseGrades(course.getCourseID()).addGrade(firstGrade);
		student.getCourseGrades(course.getCourseID()).addGrade(secondGrade);
		course.addStudent(student);
	}

}
