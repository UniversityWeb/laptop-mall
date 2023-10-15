package com.webteam.laptopmall.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_colors")
public class ProdColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProdColor() {
    }

    public ProdColor(Integer id, String name, Product product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProdColor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
