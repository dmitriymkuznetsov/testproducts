package net.developer.testproducts.controller;

import net.developer.testproducts.modelview.Filter;
import net.developer.testproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Product controller
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Generate view-page of search form and products list
     *
     * @param model
     * @return view-page
     */
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        Filter filter = new Filter();

        model.put("filter", filter);
        model.put("productList", productService.getProductByFilter(filter));

        return "index";
    }

    /**
     * Generate view-page of search form with products search result
     *
     * @param filterForm filter object
     * @param bindingResult validate results
     * @param model
     * @return view-page
     */
    @RequestMapping(name = "/", method = RequestMethod.POST)
    public String findProducts(@ModelAttribute("filter") Filter filterForm, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()) {
            model.put("filter", filterForm);
            model.put("productList", productService.getProductByFilter(new Filter()));
            return "index";
        }
        model.put("productList", productService.getProductByFilter(filterForm));

        return "index";
    }
}
