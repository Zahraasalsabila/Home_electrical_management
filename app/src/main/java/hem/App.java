package hem;

import hem.controller.ElectricityController;
import hem.view.HomeScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
   
        primaryStage.setResizable(false);

        primaryStage.setTitle("Electricity Usage");
        
        primaryStage.getIcons().add(new Image("/png/Logo.jpeg"));
        ElectricityController electricityController = new ElectricityController();
        HomeScene homeScene = new HomeScene(primaryStage, electricityController);

        homeScene.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
