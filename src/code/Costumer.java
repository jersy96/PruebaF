package code;

import java.util.ArrayList;

public class Costumer {

    private String name;
    private Long ID;
    private String address;
    private String mail;
    private Long phone;
    private int points = 0;
    private int totalSpended = 0;

    public Costumer(String name, Long id, String address, String mail, Long phone) {
        this.name = name;
        this.ID = id;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public Long getPhone() {
        return phone;
    }

    public int getPoints() {
        return points;
    }

    public int getTotalSpended() {
        return totalSpended;
    }
        public void setName(String name) {
        this.name = name;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public void changeTotalSpended(int change) {
        totalSpended += change;
        this.points += change / 100;
    }
    public void buy(ArrayList<Product> products) {
        Bill bill = new Bill(this, products);
    }

}
