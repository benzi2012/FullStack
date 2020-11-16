package SanityTests;
import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners(Utilities.listeners.class)
public class nopCommerceWebDB extends commonOps
{
    @Test(description = "Test 01: Register to nopCommerceWeb with DB")
    @Description("Test Description: Register to nopCommerceWeb with DB")
    public void test01_registerDB() throws InterruptedException
    {
        webFlows.registerDB(new Random().nextInt()+"@gmail.com",getData("Password"));
        verifications.visibleText(nopCommerceRegisterPage.txt_registrationConfirmation, "Your registration completed");

    }

}
