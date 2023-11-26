package entities;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private int courseID;
	private String description;
	private String startYear;

	private Teacher teacher;
	private List<Student> students = new ArrayList<>();

	public Course(String name, int courseID, String description, String startYear, Teacher teacher) {
		this.name = name;
		this.courseID = courseID;
		this.description = description;
		this.startYear = startYear;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartYear() {
		return startYear;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return  name;
	}
	

}
