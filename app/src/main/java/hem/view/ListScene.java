package hem.view;

import hem.controller.ElectricityController;
import hem.model.Electricity;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ListScene {
    private Stage stage;
    private ElectricityController controller;

    public ListScene(Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        TableView<Electricity> table = new TableView<>();
        table.getStyleClass().add("table-view");

        TableColumn<Electricity, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Electricity, Double> jamColumn = new TableColumn<>("Jam");
        jamColumn.setCellValueFactory(new PropertyValueFactory<>("jam"));
        TableColumn<Electricity, Double> wattColumn = new TableColumn<>("Watt");
        wattColumn.setCellValueFactory(new PropertyValueFactory<>("watt"));
        table.getColumns().addAll(nameColumn, jamColumn, wattColumn);

        List<Electricity> electricityList = controller.getAllElectricity();
        table.getItems().addAll(electricityList);

        Button home = new Button("Kembali");
        home.setOnAction(e -> {
            ElectricityView home1 = new ElectricityView(stage, controller);
            home1.show();
        });

        Button calculateButton = new Button("Pilih Golongan");
        GolonganScene gls = new GolonganScene(stage, controller);
        calculateButton.getStyleClass().add("button-golongan");
        calculateButton.setPrefWidth(229);
        calculateButton.setPrefHeight(32);
        calculateButton.setOnAction(e -> gls.show());

        Button clearButton = new Button("Hapus");
        clearButton.setPrefWidth(34);
        clearButton.setPrefHeight(32);
        clearButton.setStyle("-fx-background-color: #CBC9BF; -fx-border-radius: 7px;");
        clearButton.setOnAction(e -> {
            controller.clearAllElectricity();
            List<Electricity> electricityListAfterDelete = controller.getAllElectricity();
            table.getItems().clear();
            table.getItems().addAll(electricityListAfterDelete);
        });

        String buttonStyle = "-fx-background-color: #CBC9BF; -fx-text-fill: black; -fx-font-size: 16px; -fx-font-family: 'Semi Bold Italic'; -fx-background-radius: 10; -fx-font-weight: bold;";
        home.setStyle(buttonStyle);
        home.setPrefWidth(100);

        HBox pilih = new HBox(clearButton, home);
        pilih.setSpacing(10);

        VBox layout = new VBox(10, table, calculateButton, pilih);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
