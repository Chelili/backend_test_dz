package com.geekbrains;

import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;

public class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configFile;
    public static String apiKey;
    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        apiKey =  prop.getProperty("apiKey");
        baseUrl= prop.getProperty("base_url");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }


    public File getFile(String name) {
        String resource = getClass().getSimpleName() + "/" + name;
        String file = Objects.requireNonNull(getClass().getResource(resource)).getFile();
        return new File(file);
    }



}
