package com.example.glassio;

public class ListViewData {

    private String name;
    private Integer image;
    private Double price;

    public ListViewData() {

    }
    public ListViewData(String name, Integer image,  Double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
