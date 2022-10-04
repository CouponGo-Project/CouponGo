package com.coupongo.api.controller;

import com.coupongo.business.abstracts.ProductService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Product;
import com.coupongo.entities.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getall")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("add")
    public Result addProduct(@RequestBody ProductRequest productRequest) {
        return  this.productService.addProduct(productRequest);
    }

    @DeleteMapping("delete")
    public DataResult<Product> deleteProduct(int productId) {
        return  this.productService.deleteProduct(productId);
    }

    public DataResult<Product> updateProduct(Product product) {
        return null;
    }
}
