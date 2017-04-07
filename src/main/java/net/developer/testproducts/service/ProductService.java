package net.developer.testproducts.service;

import net.developer.testproducts.model.Product;
import net.developer.testproducts.modelview.Filter;

import java.util.List;

/**
 * Products services
 */
public interface ProductService {

    /**
     * Select products by filter
     *
     * @param filter object with filter criteria
     * @return List<Product> of filtered products
     */
    public List<Product> getProductByFilter(Filter filter);
}
