package com.minorius.server;

import com.minorius.entity.Product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by minorius on 23.03.2017.
 */
public class CategorySerializable implements Serializable {

    private static final long serialVersionUID = 4008632469733847506L;

    private long id;
    private String name;
    private long version;

    private List<ProductSerializable> productList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<ProductSerializable> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductSerializable> productList) {
        this.productList = productList;
    }
}
