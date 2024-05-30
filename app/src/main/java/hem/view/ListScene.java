package hem.view;

import hem.controller.ElectricityController;
import hem.model.Electricity;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

        String buttonStyle = "-fx-background-color: #CBC9BF; -fx-text-fill: black; -fx-font-size: 16px; -set-font-family : Semi Bold Italic;  -fx-background-radius: 10;  -fx-font-weight: bold;";
        home.setStyle(buttonStyle);
        home.setPrefWidth(100);



        VBox layout = new VBox(10);
        layout.getChildren().addAll(table);
        layout.getChildren().add(home);

        Scene scene = new Scene(layout, 740, 480);
        scene.getStylesheets().add(getClass().getResource("/style/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
