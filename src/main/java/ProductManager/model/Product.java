package ProductManager.model;

public class Product {
    private int id;
    private String name;
    private int Price;
    private String comment;

    public Product(){
    }

    public Product(int id, String name, int price, String comment) {
        this.id = id;
        this.name = name;
        Price = price;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
