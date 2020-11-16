package PageObjects.nop4YouMobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class settingsPage
{
    @FindBy(how = How.XPATH, using = "//*[@class='android.view.ViewGroup' and ./*[@text='Currency:']]/*[@class='android.view.ViewGroup'][2]")
    public WebElement currencyField;

    @FindBy(how = How.XPATH, using = "//*[@id='select_dialog_listview']/*[@id='text1']")
    public List<WebElement> lst_currency;
}
