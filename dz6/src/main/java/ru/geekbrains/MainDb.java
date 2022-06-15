package ru.geekbrains;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.geekbrains.db.dao.ProductsMapper;
import ru.geekbrains.db.model.Products;

import java.io.IOException;
@Slf4j
public class MainDb {
    static Faker faker = new Faker();
    private static String resource = "mybatisConfig.xml";
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;
        try {
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ProductsMapper productsMapper = sqlSession.getMapper(ProductsMapper.class);
        Products product = productsMapper.selectByPrimaryKey(12042L);
        log.info(product.getTitle());
    }
}
