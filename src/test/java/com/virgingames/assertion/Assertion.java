package com.virgingames.assertion;


import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Assertion extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com";
        RestAssured.basePath = "/bingo";
        response = given()
                .when()
                .get("/GetBingoLobbyFeed.do")
                .then().statusCode(200);
    }

    @Test
    public void test() {
        response.parser("text/plain", Parser.JSON).body("bingoLobbyInfoResource.streams[6].streamId", equalTo(1257));
        response.parser("text/plain", Parser.JSON).body("bingoLobbyInfoResource.streams[6].streamName", equalTo("SuperlinksVirgin"));
    }
}
