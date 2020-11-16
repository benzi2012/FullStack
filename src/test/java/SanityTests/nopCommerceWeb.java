package SanityTests;

import Extentions.uiActions;
import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
@Listeners(Utilities.listeners.class)
public class nopCommerceWeb extends commonOps
{
    @Test(description = "Test 01: Register to nopCommerce")
    @Description("Test Description: Create a new user in nopCommerce web application")
    public void test01_register() throws InterruptedException
    {

        webFlows.register(getData("FirstName"),getData("LastName"),new Random().nextInt()+"@gmail.com",getData("Password"));
        verifications.visibleText(nopCommerceRegisterPage.txt_registrationConfirmation, "Your registration completed");

    }

    @Test(description = "Test 02: Add Item to Cart")
    @Description("Test Description: Add a new item to nopCommerce web application shopping cart")
    public void test02_addToCart() throws InterruptedException
    {
        webFlows.addItemToCart();
        verifications.numberOfElements(nopCommerceShoppingCartPage.rows, 1);
    }

    @Test(description = "Test 03: Remove Item from Cart")
    @Description("Test Description: Remove item from nopCommerce web application shopping cart")
    public void test03_removeFromCart() throws InterruptedException
    {
        webFlows.addItemToCart();
        uiActions.mouseHoverElements(nopCommerceUpperBarPage.lnk_shoppingCart, nopCommerceUpperBarPage.btn_goToCart);
        uiActions.click(nopCommerceShoppingCartPage.box_RemoveProductBox);
        uiActions.click(nopCommerceShoppingCartPage.btn_updateShoppingCart);
        verifications.visibleText(nopCommerceShoppingCartPage.txt_emptyShoppingCart, "Your Shopping Cart is empty!");

    }

    @Test(description = "Test 04: Sorting items")
    @Description("Test Description: Sorting Items in nopCommerce Web Application ")
    public void test04_sortBy() throws InterruptedException
    {
        String[] expItem = new String[]{getData("expectedItem1"),getData("expectedItem2"),getData("expectedItem3")};
        webFlows.sortItemsBy(getData("SortingMethod"));

        for (int i = 0; i < nopCommerceCellPhonesPage.lst_itemGrid.size(); i++)
        {

            assertEquals(expItem[i],nopCommerceCellPhonesPage.lst_itemGrid.get(i).getText());
        }
    }

    @Test(description = "Test 05: Empty Search Popup Alert")
    @Description("Test Description: Verify empty search popup alert when search field is empty")
    public void test05_emptySearchPopup() throws InterruptedException
    {
        uiActions.clearText(nopCommerceUpperBarPage.txt_searchStore);
        uiActions.click(nopCommerceUpperBarPage.btn_search);
        popup = driver.switchTo().alert();
        String popupText = popup.getText();
        try
        {
            verifications.visibleTextString(popupText, "Please enter some search keyword");
        }
        catch (Exception e)
        {
            fail();
        }
        finally
        {
            popup.accept();
        }
    }
    @Test(description = "Test 06: Verify nopCommerce Logo")
    @Description("Test Description:Verify nopCommerce default Logo")
    public void test06_Verify()
    {
        verifications.visualElement(nopCommerceUpperBarPage.img_logo,"nopCommerceLogo_ver01");
    }

    @Test(description = "Test07: Verify Elements Location By Y Axis")
    @Description("Test Description: Verify NopCommerce top-menu Element Location By Y Axis")
    public void test07_verifyYaxis() {
        for (int i = 1; i < nopCommerceHeadermenuPage.lnk_topmenu.size(); i++) {
            assertEquals(nopCommerceHeadermenuPage.lnk_topmenu.get(i - 1).getLocation().getY(), nopCommerceHeadermenuPage.lnk_topmenu.get(i).getLocation().getY());
            System.out.println(nopCommerceHeadermenuPage.lnk_topmenu.get(i).getLocation().getY());
        }
    }
}

