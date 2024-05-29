package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class HomeScene {
    private ElectricityController controller;
    private Stage stage;

    public HomeScene(Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        ElectricityView eview = new ElectricityView(stage,controller);
        Image image = new Image("/png/BackgroundStart.png"); // Adjust the path as needed
        ImageView imageView = new ImageView(image);

        Button mulai = new Button("Start");
        mulai.setStyle("-fx-background-color: #FFF4CC; -fx-font-size: 20px; -fx-font-style: italic; -fx-border-radius: 9px;");
        mulai.getStyleClass().add("button");
        mulai.setPrefWidth(164);
        mulai.setPrefHeight(34);
        mulai.setLayoutX(288);
        mulai.setLayoutY(339);
        mulai.setOnAction(e -> eview.show());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, mulai);
        StackPane.setAlignment(mulai,javafx.geometry.Pos.CENTER);
        StackPane.setMargin(mulai, new Insets(217, 0, 0, 0));


        Scene scene = new Scene(stackPane,image.getWidth(), image.getHeight());        
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setTitle("Electricity Usage");
        stage.setScene(scene);
        stage.show();

    }
}
