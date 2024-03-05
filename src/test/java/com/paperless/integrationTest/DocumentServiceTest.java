package com.paperless.integrationTest;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import java.util.Map;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DocumentServiceTest {
    @Test
    @Order(1)
    void uploadDocumentTest() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        File testUploadFile = new File("src/test/java/com/paperless/TestPDF/Test.pdf");
        Response response = given()
                .multiPart("document", testUploadFile)
                .accept(ContentType.JSON)
                .when()
                .post("/api/documents/post_document/")
                .then()
                .statusCode(201)
                .extract()
                .response();

        // Validate that the response has the status code of 201
        response.then().assertThat().statusCode(201);
    }

    @Test
    void searchDocuments() throws InterruptedException {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;

        // Wait for some time to ensure that indexing of the pdf document is complete
        Thread.sleep(10000);

        String response = given()
                .accept(ContentType.JSON)
                .param("query", "Test")
                .when()
                .get("/api/documents/")
                .then()
                .statusCode(200)
                .body("results.title", hasItem("Test.pdf")) // Check that the image file is in the results
                .extract()
                .body()
                .asString();

        // Parse the response body to verify the desired results are included
        JsonPath jsonPath = new JsonPath(response);
        List<Map<String, Object>> results = jsonPath.getList("results");
    }
}

