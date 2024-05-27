package hem.view;

// import java.util.List;

// import hem.view.*;
import hem.controller.ElectricityController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// import hem.model.Electricity;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.HBox;
// import javafx.collections.FXCollections;
// import javafx.scene.control.cell.PropertyValueFactory;

public class GolonganScene {
    private ElectricityController controller;
    private Stage stage;


    public GolonganScene(Stage stage, ElectricityController controller){
        this.stage= stage;
        this.controller = controller;
    }
    public void show(){
        DRSScene drsScene = new DRSScene(stage,controller);
        Button rumahTangga = new Button("Rumah Tangga");
        rumahTangga.setOnAction(e-> drsScene.show());
        DIScene diScene = new DIScene(stage,controller);
        Button industri = new Button("Industri");
        industri.setOnAction(e-> diScene.show());
        DPScene dpScene = new DPScene(stage, controller);
        Button pemerintah = new Button("Pemerintah");
        pemerintah.setOnAction(e-> dpScene.show());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(rumahTangga, industri, pemerintah);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

}
