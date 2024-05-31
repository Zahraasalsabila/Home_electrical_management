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
            // home.setPrefWidth(300);
            // home.getStyleClass().add("button-list");
            home1.show();
        });
        home.setMaxWidth(100);
        home.getStyleClass().add("button-list");
        // home.setPrefHeight(40);

        Button calculateButton = new Button("Pilih Golongan");
        GolonganScene gls = new GolonganScene(stage, controller);
        calculateButton.getStyleClass().add("button-list");
        calculateButton.setMaxWidth(150);
        calculateButton.setPrefHeight(40);
        calculateButton.setOnAction(e -> gls.show());

        Button clearButton = new Button("Hapus");
        clearButton.getStyleClass().add("button-listC");
        clearButton.setMaxWidth(100);
        // clearButton.setPrefWidth(40);
        // clearButton.setPrefHeight(32);
        clearButton.setOnAction(e -> {
            controller.clearAllElectricity();
            List<Electricity> electricityListAfterDelete = controller.getAllElectricity();
            table.getItems().clear();
            table.getItems().addAll(electricityListAfterDelete);
        });

        

        
        // HBox buttonBox = new HBox(10, home, clearButton, calculateButton);
        // buttonBox.setPadding(new Insets(10));
        // buttonBox.setSpacing(10);

        // VBox layout = new VBox(10, table, buttonBox);
        // layout.setPadding(new Insets(10));

        HBox cal = new HBox(calculateButton);
        cal.setPadding(new Insets(0,0,0,-540));
        HBox pos = new HBox(10, cal, clearButton, home);
        pos.setPadding(new Insets(0,0,0,540));



        // GridPane position = new GridPane();
        // position.setHgap(10);
        // position.setVgap(10);
        // position.add(home, 52, 0);
        // position.add(clearButton, 45, 0);
        // position.add(calculateButton, 0, 0);

        VBox layout = new VBox(10, table, pos);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
