package Extentions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends commonOps
{
    @Step("Get Data From Server")
    public static Response get(String paramValues)
    {
        response = httpRequest.get(paramValues);
        response.prettyPrint();
        return response;
    }
    @Step("Extract Value from JSON Format")
    public static String extractFromJSON(Response  response,String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }
    @Step("Post Data to")
    public static void post( JSONObject params,String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Post Data to")
    public static void put( JSONObject params,String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }


    @Step("Delete Data from Server")
    public static void delete(String resource)
    {
        response = httpRequest.delete(resource);
        response.prettyPrint();
    }




}
