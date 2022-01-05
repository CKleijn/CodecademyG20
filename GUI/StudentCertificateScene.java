package GUI;

import database.CertificateSQL;
import domain.Certificate;
import domain.Student;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentCertificateScene {
    private CertificateSQL sqlC = new CertificateSQL();
    

    public Scene studentCertificateScene(Stage window, Student current_student) {
        StudentRegistrationScene studentRegistrationScene = new StudentRegistrationScene();

        //Layout of the text in the buttons
        Font font = Font.font("Verdana");

        // Background image
        Image image = new Image("resources/backgroundImage.jpg");
        ImageView imageView = new ImageView(image);
        Group root = new Group();
        root.getChildren().addAll(imageView);

        // Button to go back to the previous scene.
        Button backButton = new Button("Back");
        backButton.setPrefSize(80, 37);
        backButton.setFont(font);
		backButton.setStyle("-fx-background-color: #6BCAE2; -fx-text-fill: #FFFFFF; -fx-font-size: 13");
        backButton.setOnAction((event) -> {
            window.setScene(studentRegistrationScene.studentRegistrationScene(window, current_student));
        });

        HBox menu = new HBox(backButton);
        menu.setSpacing(10);

        TableView<Certificate> table = new TableView<Certificate>();
        TableColumn<Certificate, String> idCol = new TableColumn<Certificate, String>("Certificate ID");
        TableColumn<Certificate, String> gradeCol = new TableColumn<Certificate, String>("Certificate grade");
        TableColumn<Certificate, String> externalPersonIdCol = new TableColumn<Certificate, String>("External Person ID");
        
        table.getColumns().addAll(idCol, gradeCol, externalPersonIdCol);

        ObservableList<Certificate> list = sqlC.getCertificateListFromStudent(current_student);

        idCol.setCellValueFactory(new PropertyValueFactory<Certificate, String>("certificateID"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<Certificate, String>("certificateGrade"));
        externalPersonIdCol.setCellValueFactory(new PropertyValueFactory<Certificate, String>("externalPersonID"));

        table.setItems(list);
        table.setMaxSize(1485, 400);

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.getChildren().add(imageView);
        pane.setTop(menu);
        pane.setCenter(table);

        Scene sscene = new Scene(pane, 1080, 620);
        return sscene;
    }
}