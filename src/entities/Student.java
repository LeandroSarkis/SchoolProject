package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

	private int enrollmentNumber;
	private String level;
	private String registrationDate;

	private List<CourseGrades> courseGrades = new ArrayList<>();

	public Student(String name, int enrollmentNumber, String level, String registrationDate) {
		this.name = name;
		this.enrollmentNumber = enrollmentNumber;
		this.level = level;
		this.registrationDate = registrationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(int enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void addCourse(CourseGrades Course) {
		this.courseGrades.add(Course);
	}

	public CourseGrades getCourseGrades(int courseID) {
		for(CourseGrades grade : this.courseGrades) { 
			if(grade.getCourse().getCourseID() == courseID) {
				return grade;
			}
		}
		return null;
	}
}
