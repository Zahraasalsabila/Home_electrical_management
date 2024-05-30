package hem.view;

import java.util.List;

import hem.controller.ElectricityController;
import hem.model.Electricity;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ElectricityView {
    private ElectricityController controller;
    private TableView<Electricity> table; // Pindahkan deklarasi TableView ke sini
    private Stage stage;

    public ElectricityView(Stage stage, ElectricityController controller){
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {

        Rectangle rectangle = new Rectangle(353, 456);
        rectangle.setFill(Color.web("092173"));
        rectangle.setArcHeight(70);
        rectangle.setArcWidth(70);
        HBox rec = new HBox(rectangle);
        rec.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.setId("root");
        root.getChildren().add(rec);
        stage.setTitle("Electricity Usage");

        String label = "-fx-text-fill: white; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;-fx-background-radius: 25; -fx-font-weight: bold; -fx-font-style: italic;";

        String la = "-fx-background-color: #CBC9BF;-fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;-fx-background-radius: 5;";

        Label nameLabel = new Label("Nama Barang: ");
        nameLabel.setStyle(label);
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        nameInput.setPrefSize(229, 32);
        nameInput.setStyle(la);
        GridPane.setConstraints(nameInput, 1, 0);

        Label jamLabel = new Label("Pemakaian:");
        jamLabel.setStyle(label);
        GridPane.setConstraints(jamLabel, 0, 1);
        TextField jamInput = new TextField();
        jamInput.setPrefSize(229, 32);
        jamInput.setStyle(la);
        GridPane.setConstraints(jamInput, 1, 1);

        Label wattLabel = new Label("Watt:");
        wattLabel.setStyle(label);
        GridPane.setConstraints(wattLabel, 0, 2);
        TextField wattInput = new TextField();
        wattInput.setStyle(la);
        wattInput.setPrefSize(229, 32);
        GridPane.setConstraints(wattInput, 1, 2);

        Button addButton = new Button("+");
        GridPane.setConstraints(addButton, 1, 3);
        addButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
        addButton.setPrefWidth(34);
        addButton.setPrefHeight(32);
        addButton.setLayoutX(212);
        addButton.setLayoutY(325);
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            double jam = Double.parseDouble(jamInput.getText());
            double watt = Double.parseDouble(wattInput.getText());
            controller.addElectricity(new Electricity(name, jam, watt));
            nameInput.clear();
            jamInput.clear();
            wattInput.clear();

            // Ambil ulang data dari database
            List<Electricity> electricityList = controller.getAllElectricity();
            // Bersihkan tabel sebelum menambahkan data
            table.getItems().clear();
            // Tambahkan kembali semua data ke dalam tabel
            table.getItems().addAll(electricityList);
        });

        Button clearButton = new Button("C");
        GridPane.setConstraints(clearButton, 1, 5);
        clearButton.setPrefWidth(34);
        clearButton.setPrefHeight(32);
        addButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
        clearButton.setLayoutX(212);
        clearButton.setLayoutY(325);
        clearButton.setOnAction(e -> {
            controller.clearAllElectricity();
            // Ambil ulang data dari database
            List<Electricity> electricityListAfterDelete = controller.getAllElectricity();
            // Bersihkan tabel sebelum menambahkan data
            table.getItems().clear();
            // Tambahkan kembali semua data ke dalam tabel
            table.getItems().addAll(electricityListAfterDelete);
        });

        Button calculateButton = new Button("Pilih Golongan");
        GolonganScene gls = new GolonganScene(stage, controller);
        GridPane.setConstraints(calculateButton, 1, 4);
        addButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
        calculateButton.setPrefWidth(229);
        calculateButton.setPrefHeight(32);
        calculateButton.setLayoutX(373);
        calculateButton.setLayoutY(322);
        calculateButton.setOnAction(e -> gls.show());

        Button listButton = new Button("Daftar");
        GridPane.setConstraints(listButton, 1, 6);
        addButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
  
        listButton.setPrefWidth(96);
        listButton.setPrefHeight(29);
        listButton.setLayoutX(373);
        listButton.setLayoutY(322);
        listButton.setOnAction(e -> {
            ListScene ls = new ListScene(stage, controller);
            ls.show();
        });

        String btn = "-fx-background-color: #CBC9BF; -fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;  -fx-background-radius: 10; -fx-font-weight: bold;";

        listButton.setStyle(btn);
        calculateButton.setStyle(btn);
        addButton.setStyle(btn);
        clearButton.setStyle(btn);


        VBox nama = new VBox(nameLabel, nameInput);
        VBox jam = new VBox(jamLabel, jamInput);
        VBox watt = new VBox(wattLabel, wattInput);
        HBox buton = new HBox(5,addButton, calculateButton, clearButton);
        VBox you = new VBox(10,nama, jam, watt);
        HBox daftar = new HBox(listButton);
        daftar.setAlignment(Pos.CENTER);
        VBox bawa = new VBox(10,buton, daftar);
        VBox all = new VBox(80,you, bawa);
        all.setPadding(new Insets(32,0,0,205));




        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.getChildren().add(all);


        root.getChildren().addAll(grid);
        root.getStyleClass().add("start");
        

        Scene scene = new Scene(root, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void start(Stage stage2) {
    
    }
}
