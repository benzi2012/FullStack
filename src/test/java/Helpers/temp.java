package Helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class temp
{
    String url ="http://localhost:3000";
    RequestSpecification httpRequest;
    Response response;

    @Test
    public void testing()
    {
        JSONObject params = new JSONObject();
        params.put("title","ATeamBenzi");
        params.put("author" ,"Benzi");
        RestAssured.baseURI =url;
        httpRequest =RestAssured.given();
        httpRequest.header("Content-Type","application/json");


        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/posts/");
        response = httpRequest.delete("/posts/1");
        response = httpRequest.get(" /posts/1");
        response.prettyPrint();
    }

}
