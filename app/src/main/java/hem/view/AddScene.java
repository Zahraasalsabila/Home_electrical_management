// package hem.view;


// import java.util.List;

// import hem.controller.ElectricityController;
// import hem.model.Electricity;
// import javafx.stage.Stage;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.image.Image;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.StackPane;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.image.ImageView;


// public class AddScene {
//     private AddSceneController controller;
//     private Stage stage;

//     public AddScene(Stage stage, AddSceneController controller) {
//         this.stage = stage;
//         this.controller = controller;
//     }

//     public void show() {
        
//         AddScene view = new AddScene(stage,controller);
//         Image image = new Image("/png/Start.png"); // Adjust the path as needed
//         ImageView imageView = new ImageView(image);

//         StackPane root = new StackPane();
//         root.setId("root");
//         stage.setTitle("Electricity Usage");


//         Label nameLabel = new Label("Name:");
//         GridPane.setConstraints(nameLabel, 0, 0);
//         TextField nameInput = new TextField();
//         GridPane.setConstraints(nameInput, 1, 0);
    
//         Label jamLabel = new Label("Jam:");
//         GridPane.setConstraints(jamLabel, 0, 1);
//         TextField jamInput = new TextField();
//         GridPane.setConstraints(jamInput, 1, 1);
    
//         Label wattLabel = new Label("Watt:");
//         GridPane.setConstraints(wattLabel, 0, 2);
//         TextField wattInput = new TextField();
//         GridPane.setConstraints(wattInput, 1, 2);
    
//         Button addButton = new Button("Add Usage");
//         GridPane.setConstraints(addButton, 1, 3);
//         addButton.setOnAction(e -> {
//             String name = nameInput.getText();
//             double jam = Double.parseDouble(jamInput.getText());
//             double watt = Double.parseDouble(wattInput.getText());
//             controller.addElectricity(new Electricity(name, jam, watt));
//             nameInput.clear();
//             jamInput.clear();
//             wattInput.clear();
            
//             // Ambil ulang data dari database
//             List<Electricity> electricityList = controller.getAllElectricity();
//             // Bersihkan tabel sebelum menambahkan data
//             table.getItems().clear();
//             // Tambahkan kembali semua data ke dalam tabel
//             table.getItems().addAll(electricityList);

//             // primaryStage.setScene(scene);
//         });
    
//     }
// }

