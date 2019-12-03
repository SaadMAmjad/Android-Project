package com.example.glassio;


import java.io.Serializable;

import androidx.annotation.NonNull;

/**
 * @author Yonis Sheekh
 * @date 2019/12/01
 */

public class ListViewData implements Serializable {


    private String name;
    private String frame;
    private String colorr;
    private String type;
    private Integer image;
    private Double price;

    /**
     *
     * @param name
     * @param image
     * @param price
     * @param frame
     * @param colorr
     * @param type
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
     *
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     *
     * @param name name
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
     * @param image image
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
     * @param frame frame
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
     * @param price price
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
     * @param colorr colorr
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
     * @param type type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return name
     */

    /**
     *
     * @return
     */
    @Override
    @NonNull
    public String toString(){
        return this.name;
    }

}
