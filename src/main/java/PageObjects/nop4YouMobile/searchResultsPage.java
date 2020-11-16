package PageObjects.nop4YouMobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class searchResultsPage
{
    @FindBy(how = How.XPATH, using = "//*[@class='android.widget.LinearLayout']/*[@class='android.view.ViewGroup']/*[@class='android.widget.FrameLayout']/*[@class='android.view.ViewGroup'][1]//*[@class='android.widget.TextView'  and contains(text(), 'Nike')][1]")
    public List<WebElement> lst_searchResults;

    @FindBy(how = How.XPATH, using = "((//*[@class='android.widget.ListView']/*/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.FrameLayout']])[1]/*[@text])[3]")
    public WebElement priceItem;

}
