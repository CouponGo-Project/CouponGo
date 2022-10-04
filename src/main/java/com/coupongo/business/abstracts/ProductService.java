package com.coupongo.business.abstracts;


import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Product;
import com.coupongo.entities.ProductRequest;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result addProduct(ProductRequest productRequest);
    DataResult<Product> deleteProduct(int productId);
    DataResult<Product> updateProduct(Product product);
}