package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class DRSScene {
    private ElectricityController controller;
    private Stage stage;

    public DRSScene(Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        Button R_1 = new Button("R1 TR 900 VA-RTM ");
        R_1.setOnAction(e -> {
            double hargaPerKwh = 1352;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R__1 = new Button("R1 TR 1.300 VA");
        R__1.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R___1 = new Button("R1 TR 900 VA-RTM");
        R___1.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R_2 = new Button("R2 TR 3.500 VA-5.500 VA");
        R_2.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R_3 = new Button("R3 TR 6.600 VA");
        R_3.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button kembali = new Button("Kembali");
        kembali.setOnAction(e -> {
            GolonganScene golonganScene = new GolonganScene(stage, controller);
            golonganScene.show();
        });

        Rectangle rectangle = new Rectangle(353, 456);
        rectangle.setFill(Color.web("092173"));
        rectangle.setArcHeight(70);
        rectangle.setArcWidth(70);
        

        String buttonStyle = "-fx-background-color: #CBC9BF; -fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;  -fx-background-radius: 10;  -fx-font-weight: bold;";
        R_1.setStyle(buttonStyle);
        R__1.setStyle(buttonStyle);
        R___1.setStyle(buttonStyle);
        R_2.setStyle(buttonStyle);
        R_3.setStyle(buttonStyle);
        kembali.setStyle(buttonStyle);

        R_1.setPrefWidth(200);
        R__1.setPrefWidth(200);
        R___1.setPrefWidth(200);
        R_2.setPrefWidth(200);
        R_3.setPrefWidth(200);
        kembali.setPrefWidth(100);


        Label tangga = new Label("RUMAH TANGGA");
        tangga.getStyleClass().add("labelAtas");
        tangga.setAlignment(Pos.CENTER);
        tangga.setPrefWidth(200);
        HBox atas = new HBox(tangga);
        atas.setPadding(new Insets(10,0,0,270));

        
        VBox home = new VBox(kembali);
        home.setPadding(new Insets(10,0,0,210));


        VBox button = new VBox(22,R_1, R__1, R___1, R_2, R_3, home);
        button.setPadding(new Insets(0,0,0,0));
        button.setAlignment(Pos.CENTER);

        VBox all = new VBox(77, atas, button);


        StackPane layout = new StackPane();

        //add background
        Image backgroundImage = new Image ("png/sceneRT.jpg");
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setFitWidth(740);
        imageView.setFitHeight(480);
        imageView.setPreserveRatio(true);

        layout.getChildren().add(imageView);
        
        layout.getChildren().add(rectangle);
        layout.getChildren().addAll(all);


        Scene scene = new Scene(layout, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
