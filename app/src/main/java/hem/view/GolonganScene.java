package hem.view;

import hem.controller.ElectricityController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GolonganScene {
    private ElectricityController controller;
    private Stage stage;

    public GolonganScene (Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        DRSScene drsScene = new DRSScene(stage, controller);
        Button rumahTangga = new Button("Rumah Tangga");
        rumahTangga.setOnAction(e -> drsScene.show());  

        DIScene diScene = new DIScene(stage, controller);
        Button industri = new Button("Industri");
        industri.setOnAction(e -> diScene.show());

        DPScene dpScene = new DPScene(stage, controller);
        Button pemerintah = new Button("Pemerintah");
        pemerintah.setOnAction(e -> dpScene.show());



        Button kembali = new Button ("Kembali");
        kembali.setOnAction(e -> {
            ElectricityView view = new ElectricityView(stage, controller);
            view.show();
        });

        VBox home = new VBox(kembali);
        home.setPadding(new Insets(10,0,0,-230));

        VBox all = new VBox(21,rumahTangga, industri, pemerintah, home);
        all.setPadding(new Insets(230,0,0,255));


        //gaya tombol
        String buttonStyle = "-fx-background-color: #21427f; -fx-text-fill: white; -fx-font-size: 16px; -set-font-family : Semi Bold Italic; -fx-background-radius: 10;  -fx-font-weight: bold;";
        rumahTangga.setStyle(buttonStyle);
        industri.setStyle(buttonStyle);
        pemerintah.setStyle(buttonStyle);
        kembali.setStyle(buttonStyle);

        rumahTangga.setPrefWidth(200);
        industri.setPrefWidth(200);
        pemerintah.setPrefWidth(200);
        kembali.setPrefWidth(100);

        //menambahkan gambar header
        Image image = new Image("/png/sceneGolongan.jpg"); 
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(112);
        imageView.setFitWidth(714);
        imageView.setPreserveRatio(true);

        Rectangle rectangle = new Rectangle(714,299);
        rectangle.setFill(Color.web("#CBC9BF"));

        VBox img = new VBox(30,imageView, rectangle);
        img.setPadding(new Insets(20));


        StackPane layout = new StackPane();


        layout.getChildren().add(img);
        layout.getChildren().add(all);

 

        layout.setStyle("-fx-background-color: #FFF4CC;"); 

        Scene scene = new Scene(layout,  740, 480);
        stage.setScene(scene);
        stage.setTitle("Golongan");
        stage.show();
    }
}