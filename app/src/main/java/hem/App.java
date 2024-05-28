package hem;

import hem.controller.ElectricityController;
import hem.view.HomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        ElectricityController electricityController = new ElectricityController();
        primaryStage.setResizable(false);

        primaryStage.setTitle("Electricity Usage");
        HomeScene homeScene = new HomeScene(primaryStage, electricityController);
        homeScene.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
