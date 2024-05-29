package hem.view;

import java.util.List;

import hem.controller.ElectricityController;
import hem.model.Electricity;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        // ElectricityView eview = new ElectricityView(stage,controller);
        // Image image = new Image("/png/start.png"); // Adjust the path as needed
        // ImageView imageView = new ImageView(image);

        StackPane root = new StackPane();
        root.setId("root");
        stage.setTitle("Electricity Usage");

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        Label jamLabel = new Label("Jam:");
        GridPane.setConstraints(jamLabel, 0, 1);
        TextField jamInput = new TextField();
        GridPane.setConstraints(jamInput, 1, 1);

        Label wattLabel = new Label("Watt:");
        GridPane.setConstraints(wattLabel, 0, 2);
        TextField wattInput = new TextField();
        GridPane.setConstraints(wattInput, 1, 2);

        Button addButton = new Button("+");
        GridPane.setConstraints(addButton, 1, 3);
        addButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
        //addButton.getStyleClass().add("Rectangle");
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

        Button clearButton = new Button("Clear Usage");
        GridPane.setConstraints(clearButton, 1, 5);
        //clearButton.getStyleClass().add("Rectangle");
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
        //addButton.getStyleClass().add("Rectangle");
        calculateButton.setPrefWidth(229);
        calculateButton.setPrefHeight(32);
        calculateButton.setLayoutX(373);
        calculateButton.setLayoutY(322);
        calculateButton.setOnAction(e -> gls.show());

        Button listButton = new Button("Daftar");
        GridPane.setConstraints(listButton, 1, 6);
        addButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
        //addButton.getStyleClass().add("Rectangle");
        listButton.setPrefWidth(96);
        listButton.setPrefHeight(29);
        listButton.setLayoutX(373);
        listButton.setLayoutY(322);
        listButton.setOnAction(e -> {
            ListScene ls = new ListScene(stage, controller);
            ls.show();
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.getChildren().addAll(nameLabel, nameInput, jamLabel, jamInput, wattLabel, wattInput, addButton, clearButton, calculateButton, listButton);
        root.getChildren().addAll(grid);
        root.getStyleClass().add("start");
        //root.getStyleClass().add("Rectangle");

        // VBox layout = new VBox(10);
        // layout.getChildren().addAll(table, root);
        // layout.getStyleClass().add("start");

        Scene scene = new Scene(root, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
