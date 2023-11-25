package application;

import java.io.IOException;

import entities.Course;
import entities.CourseGrades;
import entities.Director;
import entities.School;
import entities.Student;
import entities.Teacher;
import util.AddStudentCourse;
import util.CourseReport;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

		Director alessandra = new Director("Alessandra", 123, "19/02/2002");

		School paulista = new School("Paulista", "Augusto Montenegro", 289, "19/02/2016", alessandra);

		Student leandro = new Student("Leandro", 23300017, " nono ano", "19/02/2023");
		Student kelton = new Student("Kelton", 23300020, " nono ano", "19/02/2023");

		Teacher girroto = new Teacher("giras", 22341, "20/2/1999", "program");
		Teacher poly = new Teacher("poly", 22341, "20/2/1999", "program");
		Teacher eliane = new Teacher("Eliane", 747, "20/2/2010", "calculus");

		Course calculus = new Course("Calculus", 69, "math", "20/02/2023", eliane);

		Course program = new Course("program", 70, "programmin :)", "20/02/2023", girroto);
		
		paulista.addCourse(calculus);
		
		
		// Ordem: estudante, curso, id do curso, primeira nota, segunda nota
		AddStudentCourse.addStudentCourse(leandro, calculus, 69, 4.00, 6.00);
		AddStudentCourse.addStudentCourse(kelton, calculus, 69, 2.00, 10.00);
		
		CourseReport.generateReport(calculus);
		
		
	}
}
