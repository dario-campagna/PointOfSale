package it.esteco.pos.main;

import it.esteco.pos.domain.BarCode;
import it.esteco.pos.domain.PointOfSale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePointOfSale {

    public static void main(String[] args) throws IOException {
        PointOfSale pointOfSale = new PointOfSaleFactory().consolePOS();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            displayMenu();
            switch (bufferedReader.readLine()) {
                case "1":
                    scanProduct(pointOfSale, bufferedReader);
                    break;
                case "2":
                    displayTotal(pointOfSale);
                    break;
                default:
                    displayErrorMessage();
                    break;
            }
        }

    }

    private static void scanProduct(PointOfSale pointOfSale, BufferedReader bufferedReader) throws IOException {
        System.out.print("Enter bar code: ");
        String code = bufferedReader.readLine();
        pointOfSale.onScannedProduct(new BarCode(code));
    }

    private static void displayMenu() {
        System.out.println("\n------------------------");
        System.out.println("Welcome to Point of Sale");
        System.out.println("1) Scan a product");
        System.out.println("2) Display total");
        System.out.print("Enter choice: ");
    }

    private static void displayTotal(PointOfSale pointOfSale) {
        pointOfSale.onTotalRequested();
    }

    private static void displayErrorMessage() {
        System.out.println("Invalid choice!");
    }

}
