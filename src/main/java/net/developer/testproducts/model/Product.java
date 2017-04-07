package net.developer.testproducts.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Product entity
 */
@Entity
@Table(name = "PROD")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false, scale = 2, precision = 16)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "CAT_ID", referencedColumnName = "ID")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
