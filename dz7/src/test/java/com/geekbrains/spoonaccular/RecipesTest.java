package com.geekbrains.spoonaccular;

import com.geekbrains.EquipmentItem;
import com.geekbrains.EquipmentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RecipesTest extends SpoonaccularTest {

    @Disabled
    @Test
    void testAutocompleteSearch() throws Exception {

        String actually = given()
                .param("query", "cheese")
                .param("number", 10)
                .expect()
                .when()
                .get("recipes/autocomplete")
                .body()
                .prettyPrint();

        String expected = getResource("expected.json");

        assertJson(expected, actually);
    }

    @Test
    void testTasteRecipeById() {
        given()
                .pathParam("id", 69095)
                .expect()
                .body("sweetness", is(48.15F))
                .body("saltiness", is(45.29F))
                .body("sourness", is(15.6F))
                .body("bitterness", is(19.17F))
                .body("savoriness", is(26.45F))
                .body("fattiness", is(100.0F))
                .body("spiciness", is(0.0F))
                .when()
                .get("recipes/{id}/tasteWidget.json");
    }

    @Test
    void testEquipmentById() {

        EquipmentItem target = new EquipmentItem("pie-pan.png", "pie form");

        EquipmentResponse response = given()
                .pathParam("id", 1003464)
                .expect()
                .when()
                .get("recipes/{id}/equipmentWidget.json")
                .as(EquipmentResponse.class);

        response.getEquipment()
                .stream()
                .filter(item -> item.getName().equals("pie form"))
                .peek(item -> Assertions.assertEquals(target, item))
                .findAny()
                .orElseThrow();
    }

}
