package GUI;

import java.sql.Date;
import java.time.LocalDate;

import database.CourseSQL;
import database.RegistrationSQL;
import domain.Registration;
import domain.Student;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegistrationUpdateScene extends domain.Validation{
    private CourseSQL sqlC = new CourseSQL();
    private RegistrationSQL sqlR = new RegistrationSQL();

    public Scene registrationUpdateScene(Stage window, Registration current_registration, Student current_student) {
        StudentDetailScene studentDetailScene = new StudentDetailScene();

        //Layout of the text in the buttons
		Font font = Font.font("Verdana");

		//Height of the input fields
		double heightTextAreas = 3000;
		
		//Background image
		Image image = new Image("resources/backgroundImage.jpg");
		ImageView imageView = new ImageView(image);
		Group root = new Group();
		root.getChildren().addAll(imageView);

        // Button to go back to the StudentOverviewScene.
        Button backButton = new Button("Back");
        backButton.setPrefSize(80, 37);
		backButton.setFont(font);
		backButton.setStyle("-fx-background-color: #6BCAE2; -fx-text-fill: #FFFFFF; -fx-font-size: 13");
        backButton.setOnAction((event) -> {
            window.setScene(studentDetailScene.studentDetailScene(window, current_student));
        });

        Label courseLabel = new Label("Choose course: ");
        ComboBox<String>cbxCourse = new ComboBox<>();
        cbxCourse.getItems().setAll(sqlC.getCourses());
        cbxCourse.getSelectionModel().select(current_registration.getCourseName());

        Button updateRegistration = new Button("Update registration");
		updateRegistration.setPrefSize(120, 40);
		updateRegistration.setOnAction((event) -> {
            Date date = Date.valueOf(LocalDate.now());
            Registration registration = new Registration(date, current_student.getEmail(), cbxCourse.getSelectionModel().getSelectedItem(), 1);
            sqlR.updateRegistration(current_registration, registration);
            window.setScene(studentDetailScene.studentDetailScene(window, current_student));
		});

        HBox buttonHBox = new HBox();
        buttonHBox.getChildren().addAll(updateRegistration);

        GridPane grid = new GridPane();
		grid.setPadding(new Insets(40, 0, 0, 0));
		grid.setHgap(5);
		grid.setVgap(2);
        grid.add(courseLabel, 0, 0 , 1, 1);
		grid.add(cbxCourse, 1, 0 , 1, 1);
        grid.add(buttonHBox, 0, 1 , 1, 1);
		
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.getChildren().add(imageView);
        pane.setTop(backButton);
        pane.setCenter(grid);

        Scene sscene = new Scene(pane, 1080, 620);
        return sscene;
    }
}