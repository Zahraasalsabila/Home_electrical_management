package hem.view;

import java.util.List;

import hem.controller.ElectricityController;
import hem.model.Electricity;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.layout.HBox;
// import javafx.geometry.Pos;
// import javafx.collections.FXCollections;

public class ElectricityView extends Application {
    private ElectricityController controller;
    private TableView<Electricity> table; // Pindahkan deklarasi TableView ke sini

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        controller = new ElectricityController();
    
        primaryStage.setTitle("Electricity Usage");
    
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
    
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
    
        Button addButton = new Button("Add Usage");
        GridPane.setConstraints(addButton, 1, 3);
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

            // primaryStage.setScene(scene);
        });
    
        table = new TableView<>(); // Inisialisasi TableView di sini
        
        TableColumn<Electricity, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Electricity, Double> jamColumn = new TableColumn<>("Jam");
        jamColumn.setCellValueFactory(new PropertyValueFactory<>("jam"));
        TableColumn<Electricity, Double> wattColumn = new TableColumn<>("Watt");
        wattColumn.setCellValueFactory(new PropertyValueFactory<>("watt"));
        table.getColumns().addAll(nameColumn, jamColumn, wattColumn);

        List<Electricity> electricityList = controller.getAllElectricity();
        table.getItems().clear();
        table.getItems().addAll(electricityList);
    
        Button clearButton = new Button("Clear Usage");
        GridPane.setConstraints(clearButton, 1, 5);
        clearButton.setOnAction(e -> {
            controller.clearAllElectricity();
            // Ambil ulang data dari database
            List<Electricity> electricityListAfterDelete = controller.getAllElectricity();
            // Bersihkan tabel sebelum menambahkan data
            table.getItems().clear();
            // Tambahkan kembali semua data ke dalam tabel
            table.getItems().addAll(electricityListAfterDelete);
            
        });
        Button calculateButton = new Button("Calculate Total Consumption");
        GolonganScene gls = new GolonganScene(primaryStage, controller);
        GridPane.setConstraints(calculateButton, 1, 4);
        calculateButton.setOnAction(e-> gls.show());

        grid.getChildren().addAll(nameLabel, nameInput, jamLabel, jamInput, wattLabel, wattInput, addButton, calculateButton, clearButton);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(grid, table);
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
