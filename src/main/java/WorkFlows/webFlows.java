package WorkFlows;

import Extentions.dbActions;
import Extentions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class webFlows extends commonOps
{
    @Step("Create New a New User")
    public static void register(String firstName, String lastName, String email, String password) throws InterruptedException
    {
        uiActions.click(nopCommerceUpperBarPage.lnk_register);
        Thread.sleep(1000);
        uiActions.updateText(nopCommerceRegisterPage.txt_firstName, firstName);
        uiActions.updateText(nopCommerceRegisterPage.txt_lastName, lastName);
        uiActions.updateText(nopCommerceRegisterPage.txt_email, email);
        uiActions.updateText(nopCommerceRegisterPage.txt_password, password);
        uiActions.updateText(nopCommerceRegisterPage.txt_confirmPassword, password);
        uiActions.click(nopCommerceRegisterPage.btn_registerButton);
    }
    @Step("Register nopCommerceWeb Flow with DB Credentials")
    public static void registerDB(String email, String password) throws InterruptedException
    {
        List<String> cred = dbActions.getCredentials("SELECT first_name, last_name FROM Credentials WHERE id='3'");
        uiActions.click(nopCommerceUpperBarPage.lnk_register);
        Thread.sleep(1000);
        uiActions.updateText(nopCommerceRegisterPage.txt_firstName, cred.get(0));
        uiActions.updateText(nopCommerceRegisterPage.txt_lastName, cred.get(1));
        uiActions.updateText(nopCommerceRegisterPage.txt_email, email);
        uiActions.updateText(nopCommerceRegisterPage.txt_password, password);
        uiActions.updateText(nopCommerceRegisterPage.txt_confirmPassword, password);
        uiActions.click(nopCommerceRegisterPage.btn_registerButton);
    }

    @Step("Add Item To Cart")
    public static void addItemToCart() throws InterruptedException {
        uiActions.mouseHoverElements(nopCommerceHeadermenuPage.lnk_electronics, nopCommerceHeadermenuPage.lnk_cellPhones);
        Thread.sleep(1000);
        uiActions.click(nopCommerceCellPhonesPage.btn_addToCart.get(0));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification success")));
        uiActions.mouseHoverElements(nopCommerceUpperBarPage.lnk_shoppingCart, nopCommerceUpperBarPage.btn_goToCart);
    }
    @Step("Sort Items By")
    public static void sortItemsBy(String sortingMethod) throws InterruptedException
    {

        uiActions.mouseHoverElements(nopCommerceHeadermenuPage.lnk_electronics, nopCommerceHeadermenuPage.lnk_cellPhones);
        Thread.sleep(1000);
        sortItem = new Select(driver.findElement(By.id("products-orderby")));
        sortItem.selectByVisibleText(getData("SortingMethod"));

    }
}
