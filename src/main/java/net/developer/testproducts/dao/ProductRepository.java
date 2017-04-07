package net.developer.testproducts.dao;

import net.developer.testproducts.model.Product;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Products access object
 */
public interface ProductRepository extends CrudRepository<Product, Long>, QueryDslPredicateExecutor<Product> {
}
