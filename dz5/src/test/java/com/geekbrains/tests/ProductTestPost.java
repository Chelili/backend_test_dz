package com.geekbrains.tests;

import okhttp3.ResponseBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import com.geekbrains.dto.Delete;
import com.geekbrains.dto.Product;
import com.geekbrains.enums.Category;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static com.geekbrains.tests.BaseTest.faker;
import static com.geekbrains.tests.BaseTest.productService;

public class ProductTestPost extends BaseTest{
    Product product;
    Integer id;

    //Тест создания продукта

    @BeforeEach
    void setUp() {
        product=  new Product()
                .withTitle(faker.food().dish())
                .withCategoryTitle(Category.FOOD.getName())
                .withPrice(1000);

    }
    @AfterEach
    void tearDown() throws IOException {
        productService.deleteProduct(id).execute();
    }


    @Test
    void createProductWithIntPriceTest() throws IOException {
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

    // создание продукта без названия
    @Test
    void createProductTestTitle() throws IOException {
        product.setTitle(null);
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

    // создание продукта без цены
    @Test
    void createProductTestPrice() throws IOException {
        product.setPrice(null);
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(0);
        assertThat(response.body().getId()).isNotNull();
    }

    // создание продукта категории 1
    @Test
    void createProductTestCategory1() throws IOException {
        product.setCategoryTitle((Category.FOOD.getName()));
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

    // создание продукта категории 2
    @Test
    void createProductTestCategory2() throws IOException {
        product.setCategoryTitle((Category.FURNITURE.getName()));
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.body().getCategoryTitle()).isEqualTo(product.getCategoryTitle());
        assertThat(response.body().getTitle()).isEqualTo(product.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(product.getPrice());
        assertThat(response.body().getId()).isNotNull();
    }

}