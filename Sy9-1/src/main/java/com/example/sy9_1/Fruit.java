package com.example.sy9_1;


public class Fruit {
    protected String id;
    protected String name;
    protected String price;
    protected String place;
    public Fruit(String id,String name,String price,String place){
        this.id=id;
        this.name=name;
        this.price=price;
        this.place=place;
    }
    public Fruit(){}

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
