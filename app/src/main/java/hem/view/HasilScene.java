package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

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

        VBox layout = new VBox(10);
        Label consumptionLabel = new Label("Total consumption: " + totalConsumption + " kWh");
        Label priceLabel = new Label("Price per kWh: Rp " + hargaPerKwh);
        Label totalCostLabel = new Label("Total cost: Rp " + totalHarga);

        layout.getChildren().addAll(consumptionLabel, priceLabel, totalCostLabel);
        Scene scene = new Scene(layout, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
