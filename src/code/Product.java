package code;

public class Product {
    private String name;
    private Long code;
    private int price;
    public Product(String name, Long code, int price){
        this.name = name;
        this.code = code;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public Long getCode() {
        return code;
    }
    public int getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}