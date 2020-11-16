package Extentions;

import Utilities.commonOps;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps
{
    @Step("Get The Credentials from DB")
    public static List<String> getCredentials(String query)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {

            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while Printing Table Data, See details:" + e);
        }
        return credentials;

    }
}