package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class DPScene {
    private ElectricityController controller;
    private Stage stage;

    public DPScene(Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        Button P_1 = new Button("P1(6600 VA)");
        P_1.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button P_2 = new Button("P2(6600 VA)");
        P_2.setOnAction(e -> {
            double hargaPerKwh = 1114;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button P_3 = new Button("P3(6600 VA)");
        P_3.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button kembali = new Button("Kembali");

            kembali.setOnAction(e -> {
                GolonganScene golonganScene = new GolonganScene(stage, controller);
                golonganScene.show();
            });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(P_1, P_2, P_3, kembali);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
