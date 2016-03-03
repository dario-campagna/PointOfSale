package it.esteco.pos.main;

import it.esteco.pos.adapters.display.LabelDisplayArea;
import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.PointOfSale;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PointOfSaleApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label priceDisplay = new Label();

        PointOfSale pointOfSale = new PointOfSaleFactory().screenPOS(new LabelDisplayArea(priceDisplay));

        TextField productCode = new TextField();

        Button scanBtn = new Button();
        scanBtn.setText("Scan product");
        scanBtn.setOnAction(event -> pointOfSale.onScannedProduct(new BarCode(productCode.getText())));

        Button totalBtn = new Button();
        totalBtn.setText("Total");
        totalBtn.setOnAction(event -> pointOfSale.onTotalRequested());

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(scanBtn,0,1);
        grid.add(productCode, 1, 1);
        grid.add(totalBtn, 0, 2);
        grid.add(priceDisplay, 1, 2);

        Scene scene = new Scene(grid, 400, 200);

        primaryStage.setTitle("Point of Sale");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
