package com.webteam.laptopmall.entity.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.CartItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"model", "version", "price", "color", "stock_qty", "discount_percent"})
})
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String brand;

    @Column(nullable = false)
    protected String model;

    @Column(name = "description", nullable = false)
    protected String desc;

    @Column(nullable = false)
    protected BigDecimal price;

    @Column(name = "stock_qty", nullable = false)
    protected Integer stockQty;

    @Column(name = "discount_percent")
    protected double discountPercent;

    protected String version;

    protected String color;

    @Column(name = "release_year")
    protected int releaseYear;

    @Enumerated(EnumType.STRING)
    protected ECategory category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    public Product() {
    }

    public Product(String brand, String model, String desc, BigDecimal price, Integer stockQty,
                   double discountPercent, String version, String color, ECategory category, int releaseYear) {
        this.brand = brand;
        this.model = model;
        this.desc = desc;
        this.price = price;
        this.stockQty = stockQty;
        this.discountPercent = discountPercent;
        this.version = version;
        this.color = color;
        this.category = category;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                ", discountPercent=" + discountPercent +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(discountPercent, product.discountPercent) != 0) return false;
        if (releaseYear != product.releaseYear) return false;
        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(brand, product.brand)) return false;
        if (!Objects.equals(model, product.model)) return false;
        if (!Objects.equals(desc, product.desc)) return false;
        if (!Objects.equals(price, product.price)) return false;
        if (!Objects.equals(stockQty, product.stockQty)) return false;
        if (!Objects.equals(version, product.version)) return false;
        if (!Objects.equals(color, product.color)) return false;
        if (category != product.category) return false;
        return Objects.equals(cartItems, product.cartItems);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (stockQty != null ? stockQty.hashCode() : 0);
        temp = Double.doubleToLongBits(discountPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + releaseYear;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (cartItems != null ? cartItems.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}