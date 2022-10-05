package com.coupongo.business.Services;


import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Product.Product;
import com.coupongo.requests.ProductRelated.AddProductRequest;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result addProduct(AddProductRequest addProductRequest);
    DataResult<Product> deleteProduct(int productId);
    DataResult<Product> updateProduct(Product product);
}