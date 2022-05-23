package com.jsonprocessing.services.impl;

import com.google.gson.Gson;
import com.jsonprocessing.models.dto.ProductNameAndPriceDto;
import com.jsonprocessing.models.dto.ProductSeedDto;
import com.jsonprocessing.models.entities.Product;
import com.jsonprocessing.repositories.ProductRepository;
import com.jsonprocessing.services.CategoryService;
import com.jsonprocessing.services.ProductService;
import com.jsonprocessing.services.UserService;
import com.jsonprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.jsonprocessing.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_NAME = "products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedProducts() throws IOException {

        if (productRepository.count() > 0) {
            return;
        }
        String fileContent = Files.readString(Path.of(RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(fileContent, ProductSeedDto[].class);


        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.findRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                    }

                    product.setCategories(categoryService.findRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lower, BigDecimal upper) {

        return productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(lower, upper)
                .stream()
                .map(product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper.map(product, ProductNameAndPriceDto.class);

                    productNameAndPriceDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productNameAndPriceDto;
                })
                .collect(Collectors.toList());
    }
}
