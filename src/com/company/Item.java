package com.company;

public class Item {
    private String name;
    private int price;

    public Item(String[] itemData){
        this.name= itemData[0];
        this.price= Integer.parseInt(itemData[1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
