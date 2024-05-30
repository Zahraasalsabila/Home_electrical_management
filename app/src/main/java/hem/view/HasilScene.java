package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HasilScene {
    private ElectricityController controller;
    private Stage stage;
    private double hargaPerKwh;

    public HasilScene(Stage stage, ElectricityController controller, double hargaPerKwh) {
        this.stage = stage;
        this.controller = controller;
        this.hargaPerKwh = hargaPerKwh;
    }

    public void show() {
        double totalConsumption = controller.calculateTotalConsumption();
        double totalHarga = totalConsumption * hargaPerKwh;

        Label consumptionLabel = new Label("Total consumption: ");
        Label priceLabel = new Label("Price per kWh:  ");
        Label totalCostLabel = new Label("Total cost:  ");

        VBox al = new VBox(35, consumptionLabel, priceLabel, totalCostLabel);


        Label total1 = new Label("\t" + totalConsumption + " kwh");
        Label total2 = new Label("Rp\t " + hargaPerKwh);
        Label total3 = new Label("Rp\t " + totalHarga);

        VBox teks = new VBox(35, total1, total2, total3);
        teks.setAlignment(Pos.CENTER);

        Button kembali = new Button("Kembali");
        kembali.setOnAction(e -> {
            GolonganScene golonganScene = new GolonganScene(stage, controller);
            golonganScene.show();
        });

        String buttonStyle = "-fx-background-color: #CBC9BF; -fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;  -fx-background-radius: 10; -fx-font-weight: bold;";
        kembali.setStyle(buttonStyle);
        kembali.setPrefWidth(100);

        HBox home = new HBox(kembali);
        home.setPadding(new Insets(50,0,0,40));

        HBox all = new HBox(35, al, teks);
        all.setAlignment(Pos.CENTER);

        String labelll = " -fx-text-fill: white; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;  -fx-font-weight: bold;";
        consumptionLabel.setStyle(labelll);
        priceLabel.setStyle(labelll);
        totalCostLabel.setStyle(labelll);

        String labell = "-fx-background-color: #D9D9D9; -fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;-fx-background-radius: 5;  -fx-font-weight: bold;";

        total1.setStyle(labell);
        total2.setStyle(labell);
        total3.setStyle(labell);

        total1.setPrefWidth(200);
        total2.setPrefWidth(200);
        total3.setPrefWidth(200);



        //background warna biruu
        Rectangle rectangle = new Rectangle(702, 430);
        rectangle.setFill(Color.web("#092173"));
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);


        String label = "-fx-background-color: #4A4942; -fx-text-fill: white; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;-fx-background-radius: 25;";
        Label total = new Label("TOTAL BIAYA");
        total.setStyle(label);
        total.setAlignment(Pos.CENTER);
        total.setPrefWidth(200);
        HBox atas = new HBox(total);
        atas.setPadding(new Insets(-20,0,0,270));



        VBox gbg = new VBox(80, atas, all, home);
        gbg.setAlignment(Pos.CENTER);


        //add background
        Image backgroundImage = new Image ("png/sceneRT.jpg");
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setFitWidth(740);
        imageView.setFitHeight(480);
        imageView.setPreserveRatio(true);

        StackPane layout = new StackPane();
 
        layout.getChildren().add(imageView);
        layout.getChildren().add(rectangle);
        layout.getChildren().add(gbg);
        Scene scene = new Scene(layout, 740, 480);
        stage.setScene(scene);
        stage.show();
    }
}
