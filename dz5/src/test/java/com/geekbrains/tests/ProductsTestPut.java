package com.geekbrains.tests;

import com.geekbrains.dto.Product;
import com.geekbrains.enums.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTestPut extends BaseTest {
    Product product;
    Integer id;

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
    @AfterEach
    void tearDown() throws IOException {
        productService.deleteProduct(id).execute();
    }

    //Тест изменения цены продукта
    @Test
    void modifyProductTestPrice() throws IOException {

        product
                .setPrice(55);

        Response<Product> response = productService
                .modifyProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

    //Тест изменения названия продукта
    @Test
    void modifyProductTestTitle() throws IOException {

        product
                .setTitle("fake007");

        Response<Product> response = productService
                .modifyProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

    //Тест изменения категории продукта
    @Test
    void modifyProductTestCategory() throws IOException {

        product.setCategoryTitle((Category.FURNITURE.getName()));

        Response<Product> response = productService
                .modifyProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }
}