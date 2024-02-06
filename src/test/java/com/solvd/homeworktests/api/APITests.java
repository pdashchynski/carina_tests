package com.solvd.homeworktests.api;

import com.solvd.homeworktests.domain.Product;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class APITests {

    @Test
    public void verifyGetProductById() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("iPhone 9");
        product.setDiscountPercentage(12.96);

        GetProductByIdMethod getProductByIdMethod = new GetProductByIdMethod(product.getId());
        getProductByIdMethod.addProperty("product", product);
        getProductByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getProductByIdMethod.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Double>withPredicate("discountPercentagePredicate", discountPercentage -> Objects.equals(discountPercentage, product.getDiscountPercentage()));

        getProductByIdMethod.validateResponse(comparatorContext);
    }

    @Test
    public void verifyGetProductListMethod() {
        GetProductListMethod getProductListMethod = new GetProductListMethod();
        getProductListMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getProductListMethod.callAPI();

        getProductListMethod.validateResponse();
    }

    @Test
    public void verifyGetAllCategoriesMethod() {
        GetAllCategoriesMethod getAllCategoriesMethod = new GetAllCategoriesMethod();
        getAllCategoriesMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAllCategoriesMethod.callAPI();

        getAllCategoriesMethod.validateResponse();
    }

    @Test
    public void verifyDeleteProductById() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("iPhone 9");
        product.setDiscountPercentage(12.96);

        DeleteProductByIdMethod deleteProductByIdMethod = new DeleteProductByIdMethod(product.getId());
        deleteProductByIdMethod.addProperty("product", product);
        deleteProductByIdMethod.callAPIExpectSuccess();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Double>withPredicate("discountPercentagePredicate", discountPercentage -> Objects.equals(discountPercentage, product.getDiscountPercentage()))
                .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date).isAfter(LocalDate.of(2023, 1, 1).atStartOfDay(ZoneId.systemDefault())));


        deleteProductByIdMethod.validateResponse(comparatorContext);
    }

    @Test
    public void verifyAddProductMethod() {
        Product product = new Product();
        product.setId(101);
        product.setTitle("TEST ITEM");
        product.setDescription("BLAH BLAH BLAH");
        product.setPrice(1000);
        product.setDiscountPercentage(1.11);
        product.setRating(9.99);
        product.setStock(1);
        product.setBrand("TEST BRAND");
        product.setCategory("TEST ITEMS");

        AddProductMethod addProductMethod = new AddProductMethod();
        addProductMethod.addProperty("product", product);
        addProductMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        addProductMethod.callAPI();

        addProductMethod.validateResponse();
    }

    @Test
    public void verifyUpdateProductByIdMethod() {
        Product product = new Product();
        product.setId(2);
        product.setTitle("TEST ITEM");
        product.setDescription("BLAH BLAH BLAH");
        product.setPrice(1000);
        product.setDiscountPercentage(1.11);
        product.setRating(9.99);
        product.setStock(1);
        product.setBrand("TEST BRAND");
        product.setCategory("TEST ITEMS");

        UpdateProductByIdMethod updateProductByIdMethod = new UpdateProductByIdMethod(product.getId());
        updateProductByIdMethod.addProperty("product", product);
        updateProductByIdMethod.callAPIExpectSuccess();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Integer>withPredicate("idPredicate", id -> Objects.equals(id, product.getId()));

        updateProductByIdMethod.validateResponse(comparatorContext);
    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
