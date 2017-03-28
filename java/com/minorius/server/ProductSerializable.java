package com.minorius.server;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by minorius on 26.03.2017.
 */
public class ProductSerializable implements Serializable {

    private static final long serialVersionUID = 4008632469733847506L;

    private long id;
    private String type;
    private String title;
    private int price;
    private int order_count;
    private int order_needed;
    private String image;
    private String description_short;
    private String description_full;
    private byte rating;
    private boolean is_actual;

    public ProductSerializable(){

    }

    public ProductSerializable(String type, String title, int price, int order_count, int order_needed, String image, String description_short, String description_full, byte rating, boolean is_actual) {
        this.type = type;
        this.title = title;
        this.price = price;
        this.order_count = order_count;
        this.order_needed = order_needed;
        this.image = image;
        this.description_short = description_short;
        this.description_full = description_full;
        this.rating = rating;
        this.is_actual = is_actual;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public int getOrder_needed() {
        return order_needed;
    }

    public void setOrder_needed(int order_needed) {
        this.order_needed = order_needed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription_short() {
        return description_short;
    }

    public void setDescription_short(String description_short) {
        this.description_short = description_short;
    }

    public String getDescription_full() {
        return description_full;
    }

    public void setDescription_full(String description_full) {
        this.description_full = description_full;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public boolean isIs_actual() {
        return is_actual;
    }

    public void setIs_actual(boolean is_actual) {
        this.is_actual = is_actual;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
