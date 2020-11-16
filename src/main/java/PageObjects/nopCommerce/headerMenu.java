package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class headerMenu
{
    @FindBy(how =How.XPATH,using ="//ul[@class='top-menu notmobile']/li[2]/a['Electronics']")
    public WebElement lnk_electronics;

    @FindBy(how =How.XPATH,using ="//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a['Cell phones']")
    public WebElement lnk_cellPhones;

    @FindBy(how =How.XPATH,using ="//ul[@class='top-menu notmobile']/li/a")
    public List<WebElement>lnk_topmenu;






}
