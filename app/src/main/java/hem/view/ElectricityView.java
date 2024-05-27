package hem.view;

import java.util.List;

import hem.controller.ElectricityController;
import hem.model.Electricity;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

public class ElectricityView extends Application {
    private ElectricityController controller;
    private TableView<Electricity> table; // Pindahkan deklarasi TableView ke sini

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // double hargaPerKwh;
        
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
    
        Button calculateButton = new Button("Calculate Total Consumption");
        
        GridPane.setConstraints(calculateButton, 1, 4);


        // calculateButton.setOnAction(e -> {
            // double totalConsumption = controller.calculateTotalConsumption();
            // double hargaPerKwh = 10000; // Harga per kWh
            // double totalHarga = totalConsumption * hargaPerKwh; // Menghitung total harga
            
            // Alert alert = new Alert(Alert.AlertType.INFORMATION);
            // alert.setTitle("Total Consumption and Cost");
            // alert.setHeaderText(null);
            // alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
            //                     + "Price per kWh: Rp " + hargaPerKwh + "\n"
            //                     + "Total cost: Rp " + totalHarga);
            // alert.showAndWait();
        // });

        
        
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
            
            
            // Scene akhir = new Scene();
            Button R_1 = new Button("R1(900 VA)");
            R_1.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1352;
                double totalHarga = totalConsumption * hargaPerKwh;
                // primaryStage.setScene(akhir);
                // Menghitung total harga
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();

            });
            Button R__1 = new Button("R1(1300 VA)");
            R__1.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();

            });
            Button R___1 = new Button("R1(2200 VA)");
            R___1.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button R_2 = new Button("R2(3500 VA)");
            R_2.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button R_3 = new Button("R3(6600 VA)");
            R_3.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button B_2 = new Button("B2(6600 VA)");
            B_2.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button B_3 = new Button("B3(200 kVA)");
            B_3.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1114;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button I_3 = new Button("I3(200 kVA)");
            I_3.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1114;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button I_4 = new Button("B_4(30.000 kVA)");
            I_4.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 996.74;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button P_1 = new Button("P1(66700 VA)");
            P_1.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button P_2 = new Button("P1(66700 VA)");
            P_2.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1114;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            Button P_3 = new Button("P1(66700 VA)");
            P_3.setOnAction(e-> {
                double totalConsumption = controller.calculateTotalConsumption();
                double hargaPerKwh = 1444;
                double totalHarga = totalConsumption * hargaPerKwh;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total Consumption and Cost");
                alert.setHeaderText(null);
                alert.setContentText("Total consumption: " + totalConsumption + " kWh\n"
                                    + "Price per kWh: Rp " + hargaPerKwh + "\n"
                                    + "Total cost: Rp " + totalHarga);
                alert.showAndWait();
            });
            VBox set1 = new VBox(30,R_1,R__1,R___1,R_2,R_3);
            VBox set2 = new VBox(30,B_2,B_3,I_3,I_4);
            VBox set3 = new VBox(30,P_1,P_2,P_3);
            Scene daftarRumahTangga = new Scene(set1,400,300);
            Scene daftarindustri = new Scene(set2,400,300);
            Scene daftarPemerintah = new Scene(set3);
            Button rumahTangga = new Button("Rumah Tangga");
            rumahTangga.setOnAction(e-> primaryStage.setScene(daftarRumahTangga));
            Button industri = new Button("Industri");
            industri.setOnAction(e-> primaryStage.setScene(daftarindustri));
            Button pemerintah = new Button("Pemerintah");
            pemerintah.setOnAction(e-> primaryStage.setScene(daftarPemerintah));
            
            VBox layout = new VBox(10);
            layout.getChildren().addAll(grid, table);
            Scene scene = new Scene(layout, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.show();
            Button back = new Button("back");
            back.setOnAction(e-> primaryStage.setScene(scene));
            VBox golongan = new VBox(industri,rumahTangga,pemerintah,back);
            Scene daftar = new Scene(golongan,400,300);            
            
            grid.getChildren().addAll(nameLabel, nameInput, jamLabel, jamInput, wattLabel, wattInput, addButton, calculateButton, clearButton);
            
            
    

            // Scene hargascene = new Scene(hasil);
            // primaryStage.setScene(hargascene);
            calculateButton.setOnAction(e-> primaryStage.setScene(daftar));
    }
}
