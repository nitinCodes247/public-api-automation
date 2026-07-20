package com.nitin.openf1.client;

import com.nitin.openf1.builder.RequestSpecificationBuilder;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class OpenF1Client {
    private OpenF1Client() {
    }
    public static Response get(String endpoint, Map<String, ?> queryParameters) {
        return given()
                .spec(RequestSpecificationBuilder.getDefaultRequestSpecification())
                .queryParams(queryParameters)
                .when()
                .get(endpoint);
    }
}