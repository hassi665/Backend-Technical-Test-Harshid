package com.virgingames.myfirsttest;

import com.virgingames.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class MyFirstTest extends TestBase {

    @Test
    public void getAllGames() {
        /*given()
                .when()
                .get("http://localhost:8080/student/list")
                .then()
                .statusCode(200);*/
        Response response = given()
                .when()
                .get("/GetBingoLobbyFeed.do");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
