package Controller;

import Model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private int pageSize = 5;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();

    public void showAllProduct() {
        int totalPages = getTotalPages();
        int count = 0;
        for (int i = 0; i < totalPages; i++) {
            System.out.println("Pages " + (i + 1) + "/" + totalPages);
            try {
                for (int j = i * pageSize; j < i * pageSize + pageSize; j++) {
                    System.out.println(++count + ". " + productList.get(j));
                }
            } catch (IndexOutOfBoundsException e) {}

            if (i == totalPages - 1) {
                System.out.println("Press enter to back to main menu");
                scanner.nextLine();
                return;
            } else if (totalPages > 1) {
                System.out.println("Press enter to show next product Pages");
                scanner.nextLine();
            }
        }
    }

    private int getTotalPages() {
        int totalPages;
        if (productList.size() < pageSize) {
            totalPages = 1;
        } else {
            totalPages = productList.size() / pageSize + 1;
        }
        return totalPages;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public void addNewProduct(Product product) {
        productList.add(product);
    }

    public int findProductById(String id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getId())) {
                index = i;
            }
        }
        return index;
    }

    public void editProduct(Product product, int index) {
        productList.remove(index);
        productList.add(index, product);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    public void sortByPrice() {
        Collections.sort(productList);
        showAllProduct();
    }

    public Product findMostExpensiveProduct() {
        Product product = productList.get(0);
        double max = product.getPrice();
        for (Product product1 : productList) {
            if (product1.getPrice() > max) {
                product = product1;
            }
        }
        return product;
    }

    public void openFile() {
        List<Product> temp = DataHandler.readDataFromFile();
        productList.addAll(temp);
    }

    public void saveFile() {
        DataHandler.writeToFile();
    }
}
