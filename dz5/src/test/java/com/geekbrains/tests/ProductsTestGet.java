package com.geekbrains.tests;

import com.geekbrains.dto.Product;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;


public class ProductsTestGet extends BaseTest{
    Integer code;

    //Проверка запроса всех продуктов ошибка 500
    @Test
    void GetProductWithIntPriceTest() throws IOException {

        Response<Product> response = productService
                .getAllProduct()
                .execute();
        code = response.code();
        assert code.equals(500);
    }
}