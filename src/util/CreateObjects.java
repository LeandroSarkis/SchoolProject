package util;

import java.util.List;

import entities.Course;
import entities.Director;
import entities.School;
import entities.Student;
import entities.Teacher;

public class CreateObjects {

	public static void createSchool(String name, String address, int ID, String foundationYear, Director director,
			List<School> schools) {

		schools.add(new School(name, address, ID, foundationYear, director));
	}

	public static void createStudent(String name, int enrollmentNumber, String level, String registrationDate, School school, List<Student> students) {
		
		school.addStudent(new Student(name, enrollmentNumber, level, registrationDate));
		students.add(school.getStudent(enrollmentNumber));
		
	}
	
	public static void createDirector(String name, int identificationNumber, String hiringDate, List<Director> directors) {
		
		directors.add(new Director(name, identificationNumber, hiringDate));
		
	}
	
	public static void createTeacher(String name, int identificationNumber, String hiringDate, String subject, School school, List<Teacher> teachers) {
		
		school.addTeacher(new Teacher(name, identificationNumber, hiringDate, subject));
		teachers.add(school.getTeacher(identificationNumber));
	}
	
	public static void createCourse(String name, int courseID, String description, String startYear, Teacher teacher, School school, List<Course> courses) {
		school.addCourse(new Course(name, courseID, description, startYear, teacher));
		courses.add(school.getCourse(courseID));
	}
}
