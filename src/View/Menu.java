package View;

import Controller.ProductManagement;
import Controller.ProductValidator;
import Model.Product;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    private ProductManagement productManagement = new ProductManagement();

    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    productManagement.showAllProduct();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    editProduct();
                    int index;
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    productManagement.sortByPrice();
                    break;
                case 6:
                    findMostExpensiveProduct();
                    break;
                case 7:
                    productManagement.openFile();
                    break;
                case 8:
                    productManagement.saveFile();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (option != 0);
    }

    private void findMostExpensiveProduct() {
        Product product = productManagement.findMostExpensiveProduct();
        System.out.println(product);
    }

    private void deleteProduct() {
        int index;
        index = getProductIndex();
        if (index == -1){
            System.out.println("Can not find this product, please try again");
        } else {
            productManagement.removeProduct(index);
        }
    }

    private void editProduct() {
        int index = getProductIndex();
        if (index == -1) {
            System.out.println("Can not find this product, please try again");
        } else {
            Product editedProduct = getProduct();
            productManagement.editProduct(editedProduct, index);
        }
    }

    private void addNewProduct() {
        Product newProduct = getProduct();
        productManagement.addNewProduct(newProduct);
        System.out.println("Add new product successfully");
    }

    private int getProductIndex() {
        System.out.println("Please input product id you want to edit");
        String id = scanner.nextLine();
        int index = productManagement.findProductById(id);
        return index;
    }

    private Product getProduct() {
        String id;
        String name;
        String price;
        String quantity;
        String description;

        System.out.println("Please input product Id");
        do {
            id = scanner.nextLine();
        } while (!ProductValidator.isValidated(id));

        System.out.println("Please input product name");
        do {
            name = scanner.nextLine();
        } while (!ProductValidator.isValidated(name));

        System.out.println("Please input product price");

        do {
            price = scanner.nextLine();
        } while (!ProductValidator.isPriceValidated(price));

        System.out.println("Please input product quantity");

        do {
            quantity = scanner.nextLine();
        } while (!ProductValidator.isQuantityValidated(quantity + ""));

        System.out.println("PLease input product description");

        do {
            description = scanner.nextLine();
        } while (!ProductValidator.isValidated(description));

        Product product = new Product(id, name, description, Integer.parseInt(quantity), Double.parseDouble(price));
        return product;
    }

    public void menu() {
        System.out.println("---Product Management Program----");
        System.out.println("1. Show product list");
        System.out.println("2. Add new product");
        System.out.println("3. Edit product");
        System.out.println("4. Delete product");
        System.out.println("5. Sort");
        System.out.println("6. Find the most expensive Product");
        System.out.println("7. Get product list from file");
        System.out.println("8. Save product list to file");
        System.out.println("0. Exit");
    }
}
