package Controller;

import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    final private static String filePath = "/Users/quans/Desktop/module2/TestThucHanhM2/src/Data/ProductList.txt";
    private static ProductManagement productManagement = new ProductManagement();

    public DataHandler() {
    }

    public static void writeToFile() {
        try {
            List<Product> productList = ProductManagement.getProductList();
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public static List<Product> readDataFromFile() {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.err.println("Data is empty");
        }
        return productList;
    }
}
