package com.toolshop.client;

import com.toolshop.dto.BrandDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class BrandApiClient {
    private final String baseUrl;

    public BrandApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<BrandDto> getAllBrands() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseUrl + "/brands");

        return Arrays.asList(response.as(BrandDto[].class));
    }

    public BrandDto createBrand(BrandDto brandDto) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(brandDto)
                .when()
                .post(baseUrl + "/brands");

        return response.as(BrandDto.class);
    }
}
