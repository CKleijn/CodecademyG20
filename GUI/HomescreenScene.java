package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomescreenScene{
	StudentOverviewScene studentOverviewScene = new StudentOverviewScene();
	CourseOverviewScene courseOverviewScene = new CourseOverviewScene();
	StatisticOverviewScene statisticOverviewScene = new StatisticOverviewScene();
	
	public Scene homeScene(Stage window) {

		//Layout of the text in the buttons
		Font font = Font.font("Verdana");
		
		//Background image
		Image image = new Image("resources/backgroundImage.jpg");
		ImageView imageView = new ImageView(image);
		Group root = new Group();
		root.getChildren().addAll(imageView);
		
		//First button which leads to the studentScene.
		Button studentButton = new Button("Students");
		studentButton.setPrefSize(80, 37);
		studentButton.setFont(font);
		studentButton.setStyle("-fx-background-color: #6BCAE2; -fx-text-fill: #FFFFFF; -fx-font-size: 13");
		studentButton.setOnAction((event) -> {
			window.setScene(studentOverviewScene.studentOverviewScene(window));
		});

		//Second button which leads to courseScene
		Button courseButton = new Button("Courses");
		courseButton.setPrefSize(80, 37);
		courseButton.setFont(font);
		courseButton.setStyle("-fx-background-color: #6BCAE2; -fx-text-fill: #FFFFFF; -fx-font-size: 13");
		courseButton.setOnAction((event) -> {
			window.setScene(courseOverviewScene.courseOverviewScene(window));
		});

		//Third button which leads to statisticScene
		Button statisticButton = new Button("Statistics");
		statisticButton.setPrefSize(80, 37);
		statisticButton.setFont(font);
		statisticButton.setStyle("-fx-background-color: #6BCAE2; -fx-text-fill: #FFFFFF; -fx-font-size: 13");
		statisticButton.setOnAction((event) -> {
			window.setScene(statisticOverviewScene.statisticOverviewScene(window));
		});
			
		
		Label firstWelcome = new Label("Welcome to the");
		firstWelcome.setFont(font);
		firstWelcome.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 28;");
		

		Label secondWelcome = new Label("Codecademy Application");
		secondWelcome.setFont(font);
		secondWelcome.setStyle("-fx-padding: 10; -fx-background-color: #0B9EC3; -fx-text-fill: #FFFFFF; -fx-font-size: 35;");


		Label description = new Label("description of the application");
		description.setFont(font);
		description.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 18;");
		description.setPadding(new Insets(50, 0, 0, 0));

		
		HBox menu = new HBox(studentButton, courseButton, statisticButton);
		menu.setSpacing(10);
		
		
		VBox front = new VBox(firstWelcome, secondWelcome, description);
		front.setSpacing(5);
		front.setAlignment(Pos.BASELINE_CENTER);
		front.setPadding(new Insets(150, 0, 0, 0));
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(15, 15, 15, 15));
		pane.getChildren().add(imageView);
		pane.setTop(menu);
		pane.setCenter(front);
		

		Scene homescreenScene = new Scene(pane, 1080, 620);
		
		return homescreenScene;
	}
	
}
