package WorkFlows;

import Extentions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps
{
    @Step("Get Property From Localhost")
    public static String getListProperty(String jpath)
    {
        Response response = apiActions.get("/posts");
        return apiActions.extractFromJSON(response,jpath);

    }

    @Step("creat New Section")
    public static void postSection(String title,String author)
    {
        requestParams.put("title",title);
        requestParams.put("author" ,author);
        apiActions.post(requestParams,"/posts/");

    }

    @Step("Update Section in Server")
    public static void updateSection(String title, String author, String id)
    {
        requestParams.put("title", title);
        requestParams.put("author", author);
        apiActions.put(requestParams, "/posts/" + id);
    }

    @Step("Delete Section in Server")
    public static void deleteSection(String id)
    {
        apiActions.delete("/posts/" + id);
    }
}


