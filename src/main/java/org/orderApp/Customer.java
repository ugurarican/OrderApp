package org.orderApp;

public class Customer implements ICustomer{
    private String name;
    private String date;
    private int bill;

    public Customer(String name, String date, int bill) {
        this.name = name;
        this.date = date;
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}
