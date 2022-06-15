package com.geekbrains.spoonaccular;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ImageClassificationTest extends SpoonaccularTest {

    @Disabled
    @Test
    void testBurgerClassification() {
        given()
                .multiPart(getFile("burger.jpeg"))
                .expect()
                .body("category", is("burger"))
                .body("probability", greaterThan(0.7F))
                .when()
                .post("food/images/classify");
    }

}
