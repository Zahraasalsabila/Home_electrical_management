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

public class DIScene {
    private ElectricityController controller;
    private Stage stage;

    public DIScene(Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        Button B_2 = new Button("B2(6600 VA)");
        B_2.getStyleClass().add("button-kategori");
        B_2.setOnAction(e -> {
            double hargaPerKwh = 1444.70;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button B_3 = new Button("B3(200 kVA)");
        B_3.getStyleClass().add("button-kategori");
        B_3.setOnAction(e -> {
            double hargaPerKwh = 1114.70;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button I_3 = new Button("I3(200 kVA)");
        I_3.getStyleClass().add("button-kategori");
        I_3.setOnAction(e -> {
            double hargaPerKwh = 1114;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button I_4 = new Button("I4(30.000 kVA)");
        I_4.getStyleClass().add("button-kategori");
        I_4.setOnAction(e -> {
            double hargaPerKwh = 996.74;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button kembali = new Button("Kembali");
        // kembali.getStyleClass().add("button-kategori");
        kembali.setOnAction(e -> {
            GolonganScene golonganScene = new GolonganScene(stage, controller);
            golonganScene.show();
        });

        String buttonStyle = "-fx-background-color: #CBC9BF; -fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;  -fx-background-radius: 10; -fx-font-weight: bold;";
        kembali.setStyle(buttonStyle);
        kembali.setPrefWidth(100);

        Rectangle rectangle = new Rectangle(353, 456);
        rectangle.setFill(Color.web("092173"));
        rectangle.setArcHeight(70);
        rectangle.setArcWidth(70);



        Label industri = new Label("INDUSTRI DAN BISNIS");
        industri.getStyleClass().add("labelAtas");
        industri.setAlignment(Pos.CENTER);
        industri.setPrefWidth(200);
        HBox atas = new HBox(industri);
        atas.setPadding(new Insets(10,0,0,270));

        VBox home = new VBox(kembali);
        home.setPadding(new Insets(65,0,0,210));

        VBox button = new VBox(22,B_2, B_3, I_3, I_4, home);
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
