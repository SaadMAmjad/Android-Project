package com.example.glassio;


import java.io.Serializable;

public class ListViewData implements Serializable {


    private String name;
    private String frame;
    private String colorr;
    private String type;
    private Integer image;
    private Double price;

    /**
     * @date   2019/11/13
     * @author yonis sheekh
     * @param name name of item
     * @param image image of item
     * @param price price of item
     * @param frame frame type of item
     * @param colorr color of item
     * @param type type of item (prescription or sunglasses)
     */

    public ListViewData(String name, Integer image,  Double price, String frame,String colorr,String type) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.frame = frame;
        this.colorr = colorr;
        this.type = type;
    }

    /**
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return image
     */

    public Integer getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(Integer image) {
        this.image = image;
    }

    /**
     *
     * @return frame
     */
    public String getFrame () {
        return frame;
    }

    /**
     *
     * @param frame
     */
    public void setFrame(String frame) {
        this.frame = frame;
    }

    /**
     *
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @return colorr
     */

    public String getColorr() {
        return colorr;
    }

    /**
     *
     * @param colorr
     */

    public void setColorr(String colorr) {
        this.colorr = colorr;
    }

    /**
     *
     * @return type
     */

    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return name
     */
    @Override
    public String toString(){
        return this.name;
    }

}
