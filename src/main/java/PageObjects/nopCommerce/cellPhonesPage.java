package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class cellPhonesPage
{

    @FindBy(how= How.XPATH,using="//input[@class='button-2 product-box-add-to-cart-button']")
    public List<WebElement> btn_addToCart;

    @FindBy(how=How.XPATH,using="//*[@class='item-grid']/div/div/div[2]/h2/a")
    public List<WebElement> lst_itemGrid;



}
