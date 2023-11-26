package entities;

import java.util.ArrayList;
import java.util.List;

public class School {

	private String name;
	private String address;
	private int ID;
	private String foundationYear;
	private Director director;

	private List<Teacher> teachers = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	private List<Course> courses = new ArrayList<>();

	public School(String name) {

		this.name = name;

	}
	public School(String name, String address, int ID, String foundationYear, Director director) {

		this.name = name;
		this.address = address;
		this.ID = ID;
		this.foundationYear = foundationYear;
		this.director = director;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(String foundationYear) {
		this.foundationYear = foundationYear;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public Student getStudent(int enrollmentNumber) {

		for (int i = 0; i <= students.size(); i++) {
			if (students.get(i).getEnrollmentNumber() == enrollmentNumber) {
				return students.get(i);
			}

		}
		return null;
	}
	
	public Teacher getTeacher(int identificationNumber) {

		for (int i = 0; i <= teachers.size(); i++) {
			if (teachers.get(i).getIdentificationNumber() == identificationNumber) {
				return teachers.get(i);
			}

		}
		return null;
	}
	
	public Course getCourse(int CourseID) {

		for (int i = 0; i <= courses.size(); i++) {
			if (courses.get(i).getCourseID() == CourseID) {
				return courses.get(i);
			}

		}
		return null;
	}

	public String getAllTeachersNames() {
		String teachersNames = "";
		for (int i = 0; i < teachers.size(); i++) {
			teachersNames += " " + teachers.get(i).getName() + ",";
		}
		return teachersNames;
	}

	@Override
	public String toString() {
		return name;
	}

}
