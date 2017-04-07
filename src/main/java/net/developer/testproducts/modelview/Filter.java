package net.developer.testproducts.modelview;

import java.math.BigDecimal;

/**
 * Filter view entity
 */
public class Filter {
    private String categoryName = "";
    private String productName = "";
    private BigDecimal downPrice;
    private BigDecimal upPrice;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getDownPrice() {
        return downPrice;
    }

    public void setDownPrice(BigDecimal downPrice) {
        this.downPrice = downPrice;
    }

    public BigDecimal getUpPrice() {
        return upPrice;
    }

    public void setUpPrice(BigDecimal upPrice) {
        this.upPrice = upPrice;
    }
}
