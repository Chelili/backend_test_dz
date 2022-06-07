package com.geekbrains.tests;

import com.geekbrains.dto.Product;
import com.geekbrains.enums.Category;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
public class ProductsTestDelete  extends BaseTest{
    Product product;
    Integer id;
    Integer code;
    void createsProducts() throws IOException {
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        product.setId(id);

    }


    @BeforeEach
    void setUp() throws IOException {
        product=  new Product()
                .withTitle(faker.food().dish())
                .withCategoryTitle(Category.FOOD.getName())
                .withPrice(1000);
        createsProducts();
    }

    //Тест удаления 200
    @Test
    void deleteProductTest200() throws IOException {

        Response<ResponseBody> response =
                productService
                        .deleteProduct(product.getId())
                        .execute();
        code = response.code();
        assert code.equals(200);
    }

    //Тест удаления 204
    @Test
    void deleteProductTest204() throws IOException {

        Response<ResponseBody> response =
                productService
                        .deleteProduct(000)
                        .execute();
        code = response.code();
        assert code.equals(204);
    }

    //Тест удаления 500
    @Test
    void deleteProductTest500() throws IOException {

        Response<ResponseBody> response =
                productService
                        .deleteProduct(000)
                        .execute();
        code = response.code();
        assert code.equals(500);
    }
}