package com.geekbrains.yandex;

import com.geekbrains.clients.PredictorResult;
import com.geekbrains.clients.YandexPredictorService;
import com.geekbrains.spoonaccular.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class YandexPredictorTest extends AbstractTest {

    private static YandexPredictorService service;

    @BeforeAll
    static void beforeAll() {
        service = new YandexPredictorService();
    }

    @Test
    void testGetLangs() throws Exception {
        List<String> langs = service.getLangs();
        assertJson(getResource("langs.json"), langs);
    }

    @Test
    void testPrediction() throws Exception {
        PredictorResult result = service.complete("Hello wo", "en", 3);
        assertJson(getResource("complete.json"), result);
    }

}
