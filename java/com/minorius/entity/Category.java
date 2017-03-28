package com.minorius.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "version")
    private long version;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @JoinColumn(name = "product_id")
    private List<Product> productList;

    public Category(){

    }

    public Category(String name, long version, List<Product> productList){
        this.name = name;
        this.version = version;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
