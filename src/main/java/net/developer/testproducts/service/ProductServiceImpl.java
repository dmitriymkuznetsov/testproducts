package net.developer.testproducts.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import net.developer.testproducts.dao.ProductRepository;
import net.developer.testproducts.model.Product;
import net.developer.testproducts.model.QProduct;
import net.developer.testproducts.modelview.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductByFilter(Filter filter) {
        Predicate predicate;
        BooleanExpression categoryPredicate;
        BooleanExpression productNamePredicate;
        BooleanExpression productPricePredicate = null;

        categoryPredicate = QProduct.product.category.name.startsWithIgnoreCase(filter.getCategoryName());
        productNamePredicate = QProduct.product.name.startsWithIgnoreCase(filter.getProductName());
        if (filter.getDownPrice() != null || filter.getUpPrice() != null)
            productPricePredicate = QProduct.product.price.between(filter.getDownPrice(), filter.getUpPrice());

        predicate = categoryPredicate.and(productNamePredicate).and(productPricePredicate);

        return (List<Product>) productRepository.findAll(predicate);
    }
}