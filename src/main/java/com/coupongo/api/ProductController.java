package com.coupongo.api;

import com.coupongo.business.Services.ProductService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Product.Product;
import com.coupongo.requests.ProductRelated.AddProductRequest;
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
    public Result addProduct(@RequestBody AddProductRequest addProductRequest) {
        return  this.productService.addProduct(addProductRequest);
    }

    @DeleteMapping("delete")
    public DataResult<Product> deleteProduct(int productId) {
        return  this.productService.deleteProduct(productId);
    }

    public DataResult<Product> updateProduct(Product product) {
        return null;
    }
}
