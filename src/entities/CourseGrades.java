package entities;

import java.util.ArrayList;
import java.util.List;


public class CourseGrades {
	
	private Course course;
	
	private List<Double> grades = new ArrayList<>();

	public CourseGrades(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void addGrade(Double grade) {
		if(grades.size() == 2) {
			return;
		}
		this.grades.add(grade);
	}
	
	public Double gradeAvg() {
		Double sum = 0d;

		for(Double grades : this.grades) {
			sum += grades;
		}
		
		return sum/2;
	}
}
