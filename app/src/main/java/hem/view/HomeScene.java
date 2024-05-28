package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
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
        mulai.setStyle("-fx-background-color: #FFC0CB; -fx-font-size: 14px;");
        mulai.setOnAction(e -> eview.show());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, mulai);
        StackPane.setAlignment(mulai,javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(stackPane,image.getWidth(), image.getHeight());
        stage.setTitle("Electricity Usage");
        stage.setScene(scene);
        stage.show();

    }
}
