package com.geekbrains;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ImageClassificationTest extends SpoonaccularTest {

    @Test
    void testPizzaClassification() {
        given()
                .multiPart(getFile("pizza.jpg"))
                .expect()
                .body("category", is("pizza"))
                .body("probability", greaterThan(0.7F))
                .when()
                .post("food/images/classify");
    }
}
