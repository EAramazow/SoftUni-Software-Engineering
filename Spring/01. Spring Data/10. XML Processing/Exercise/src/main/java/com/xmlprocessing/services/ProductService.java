package com.xmlprocessing.services;

import com.xmlprocessing.models.dtos.ProductSeedDto;
import com.xmlprocessing.models.dtos.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithoutBuyer();
}
