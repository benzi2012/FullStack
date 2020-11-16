package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class upperBarPage
{
    @FindBy(how = How.CLASS_NAME,using = "ico-register")
    public WebElement lnk_register;

    @FindBy(how = How.CSS,using = ".cart-label")
    public WebElement lnk_shoppingCart;

    @FindBy(how = How.XPATH,using = "//input[@value='Go to cart']")
    public WebElement btn_goToCart;

    @FindBy(how = How.ID,using= "small-searchterms")
    public WebElement txt_searchStore;

    @FindBy(how=How.CSS,using=".search-box-button")
    public WebElement btn_search;

    @FindBy(how = How.CSS,using = "[alt='nopCommerce demo store']")
    public WebElement img_logo;






}
