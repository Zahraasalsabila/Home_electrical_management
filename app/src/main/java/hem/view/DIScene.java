package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
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
        B_2.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button B_3 = new Button("B3(200 kVA)");
        B_3.setOnAction(e -> {
            double hargaPerKwh = 1114;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button I_3 = new Button("I3(200 kVA)");
        I_3.setOnAction(e -> {
            double hargaPerKwh = 1114;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button I_4 = new Button("I4(30.000 kVA)");
        I_4.setOnAction(e -> {
            double hargaPerKwh = 996.74;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(B_2, B_3, I_3, I_4);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
