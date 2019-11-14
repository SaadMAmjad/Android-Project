package com.example.glassio;


public class ListViewData {

    private String name;
    private String frame;
    private String colorr;
    private String type;
    private Integer image;
    private Double price;

    public ListViewData() {

    }
    public ListViewData(String name, Integer image,  Double price, String frame,String colorr,String type) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.frame = frame;
        this.colorr = colorr;
        this.type = type;
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


    public String getFrame () {
        return frame;
    }


    public void setFrame(String frame) {
        this.frame = frame;
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColorr() {
        return colorr;
    }

    public void setColorr(String colorr) {
        this.colorr = colorr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
