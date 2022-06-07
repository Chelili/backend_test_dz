package com.geekbrains.tests;

import com.geekbrains.dto.Product;
import com.geekbrains.enums.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTestGetID extends BaseTest{
    Product product = new Product()
            .withTitle(faker.food().dish())
            .withCategoryTitle(Category.FOOD.getName())
            .withPrice(1000);
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
        createsProducts();
    }
    @AfterEach
    void tearDown() throws IOException {
        productService.deleteProduct(id).execute();
    }

    //Тест получения информации о продукте по id code200

    @Test
    void GetProductWithIntPriceTest() throws IOException {

        Response<Product> response = productService
                .getProduct(product.getId())
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

    //Тест получения информации о несуществующем продукте по id code404

    @Test
    void GetProductWithIntPriceTest404() throws IOException {

        Response<Product> response = productService
                .getProduct(0000)
                .execute();
        code = response.code();
        assert code.equals(404);

    }

}