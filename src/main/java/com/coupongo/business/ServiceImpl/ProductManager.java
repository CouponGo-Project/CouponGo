package com.coupongo.business.ServiceImpl;


import com.coupongo.business.Services.ProductService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.CouponRepo;
import com.coupongo.dataAccess.ProductRepo;
import com.coupongo.dataAccess.UserRepos.CompanyExecutiveRepo;
import com.coupongo.dataAccess.UserRepos.UserRepo;
import com.coupongo.entities.Product.Product;
import com.coupongo.requests.ProductRelated.AddProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepo productRepo;

    private final CompanyExecutiveRepo companyExecutiveRepo;
    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>> (this.productRepo.findAll(),"Products listed");
    }

    @Override
    public Result addProduct(AddProductRequest addProductRequest) {
        Product product = new Product(
                addProductRequest.getBrand(),
                addProductRequest.getProductName(),
                addProductRequest.getQuantityInStock(),
                addProductRequest.getPricePerUnit(),
                companyExecutiveRepo.findById(addProductRequest.getCreatorID()).get()
        );
        this.productRepo.save(product);
        return new SuccessResult("Product added");
    }

    //CHANGE
    @Override
    public DataResult<Product> deleteProduct(int productId) {
        this.productRepo.deleteById(productId);
        return new SuccessDataResult<>("The Product with number: " + productId + " is deleted.");
    }

    @Override
    public DataResult<Product> updateProduct(Product product) {
        return null;
    }
}

