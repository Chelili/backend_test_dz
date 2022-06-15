package ru.geekbrains.tests;

import com.github.javafaker.Faker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.db.dao.CategoriesMapper;
import ru.geekbrains.db.dao.ProductsMapper;
import ru.geekbrains.db.model.Categories;
import ru.geekbrains.db.model.Products;
import ru.geekbrains.dto.Product;
import ru.geekbrains.enums.Category;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.geekbrains.db.dao.ProductsMapper;
import ru.geekbrains.db.model.Products;
import ru.geekbrains.db.model.ProductsExample;
import ru.geekbrains.utils.DbUtils;


public class ProductTestPost extends BaseTest{
    Product product;
    Products sqlproduct;
    Categories sqlcategories;
    Integer id;
    Long sqlid;
    String catTitle;
    static Faker faker = new Faker();
    private static String resource = "mybatisConfig.xml";

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

        sqlid = response.body().getId().longValue();
        sqlproduct = DbUtils.getproducts(sqlid);
        catTitle = DbUtils.catTitle(sqlproduct.getCategory_id());
        assertThat(response.body().getTitle()).isEqualTo(sqlproduct.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(sqlproduct.getPrice());
        assertThat(response.body().getCategoryTitle()).isEqualTo(catTitle);

    }
    @Test
    void createProductTestTitle() throws IOException {
        product.setTitle(null);
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        sqlid = response.body().getId().longValue();
        sqlproduct = DbUtils.getproducts(sqlid);
        catTitle = DbUtils.catTitle(sqlproduct.getCategory_id());
        assertThat(response.body().getTitle()).isEqualTo(sqlproduct.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(sqlproduct.getPrice());
        assertThat(response.body().getCategoryTitle()).isEqualTo(catTitle);
    }

    @Test
    void createProductTestPrice() throws IOException {
        product.setPrice(null);
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        sqlid = response.body().getId().longValue();
        sqlproduct = DbUtils.getproducts(sqlid);
        catTitle = DbUtils.catTitle(sqlproduct.getCategory_id());
        assertThat(response.body().getTitle()).isEqualTo(sqlproduct.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(sqlproduct.getPrice());
        assertThat(response.body().getCategoryTitle()).isEqualTo(catTitle);
    }

    @Test
    void createProductTestCategory1() throws IOException {
        product.setCategoryTitle((Category.FOOD.getName()));
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        sqlid = response.body().getId().longValue();
        sqlproduct = DbUtils.getproducts(sqlid);
        catTitle = DbUtils.catTitle(sqlproduct.getCategory_id());
        assertThat(response.body().getTitle()).isEqualTo(sqlproduct.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(sqlproduct.getPrice());
        assertThat(response.body().getCategoryTitle()).isEqualTo(catTitle);
    }

    @Test
    void createProductTestCategory2() throws IOException {
        product.setCategoryTitle((Category.FURNITURE.getName()));
        Response<Product> response = productService
                .createProduct(product)
                .execute();
        id = response.body().getId();
        sqlid = response.body().getId().longValue();
        sqlproduct = DbUtils.getproducts(sqlid);
        catTitle = DbUtils.catTitle(sqlproduct.getCategory_id());
        assertThat(response.body().getTitle()).isEqualTo(sqlproduct.getTitle());
        assertThat(response.body().getPrice()).isEqualTo(sqlproduct.getPrice());
        assertThat(response.body().getCategoryTitle()).isEqualTo(catTitle);
    }

}
