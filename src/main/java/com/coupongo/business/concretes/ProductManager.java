package com.coupongo.business.concretes;


import com.coupongo.business.abstracts.ProductService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.abstracts.CouponDao;
import com.coupongo.dataAccess.abstracts.ProductDao;
import com.coupongo.entities.Product;
import com.coupongo.entities.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductManager implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CouponDao couponDao;

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>> (this.productDao.findAll(),"Products listed");
    }

    @Override
    public Result addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setCoupon(couponDao.getById(productRequest.getCouponId()));
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public DataResult<Product> deleteProduct(int productId) {
        this.productDao.deleteById(productId);
        return new SuccessDataResult<>("The Product with number: " + productId + " is deleted.");
    }

    @Override
    public DataResult<Product> updateProduct(Product product) {
        return null;
    }
}

