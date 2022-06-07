package com.geekbrains.tests;

import com.geekbrains.dto.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTests extends BaseTest{

    @ParameterizedTest
    @EnumSource(value = com.geekbrains.enums.Category.class)
    void getFoodCategoryTest(com.geekbrains.enums.Category category) throws IOException {
        Response<Category> response = categoryService
                .getCategory(category.getId())
                .execute();
        assertThat(response.body().getTitle()).isEqualTo(category.getName());
        response.
                body().
                getProducts()
                .forEach(e-> assertThat(e.getCategoryTitle()).isEqualTo(category.getName()));


    }

}

