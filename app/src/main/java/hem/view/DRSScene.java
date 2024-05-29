package hem.view;

import hem.controller.ElectricityController;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class DRSScene {
    private ElectricityController controller;
    private Stage stage;

    public DRSScene(Stage stage, ElectricityController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void show() {
        Button R_1 = new Button("R1 TR 900 VA-RTM ");
        R_1.setOnAction(e -> {
            double hargaPerKwh = 1352;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R__1 = new Button("R1 TR 1.300 VA");
        R__1.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R___1 = new Button("R1 TR 900 VA-RTM");
        R___1.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R_2 = new Button("R2 TR 3.500 VA-5.500 VA");
        R_2.setOnAction(e -> {
            double hargaPerKwh = 1444;
            HasilScene hasilScene = new HasilScene(stage, controller, hargaPerKwh);
            hasilScene.show();
        });

        Button R_3 = new Button("R3 TR 6.600 VA");
        R_3.setOnAction(e -> {
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
        layout.getChildren().addAll(R_1, R__1, R___1, R_2, R_3, kembali);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
