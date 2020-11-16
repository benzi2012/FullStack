package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class shoppingCartPage
{
    @FindBy(how= How.XPATH,using = "//table[@class='cart']/tbody/tr")
    public List<WebElement> rows;

    @FindBy(how=How.NAME,using="removefromcart")
    public WebElement box_RemoveProductBox;

    @FindBy(how=How.NAME,using="updatecart")
    public WebElement btn_updateShoppingCart;

    @FindBy(how = How.CLASS_NAME,using ="no-data")
    public WebElement txt_emptyShoppingCart;

}
