package Model;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {
    private String id, name, description;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String id, String name, String description, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", price: " + price +
                ", description: '" + description + '\'' +
                ", quantity: " + quantity;

    }

    @Override
    public int compareTo(Product o) {
        return (int) (o.price - this.price);
    }
}
