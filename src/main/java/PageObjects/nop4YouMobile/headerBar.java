package PageObjects.nop4YouMobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class headerBar
{
    @FindBy(how = How.XPATH, using = "(//*[@class='android.support.v7.widget.LinearLayoutCompat']/*[@class='android.widget.TextView'])[1]")
    public WebElement btn_magnifyingGlass;

    @FindBy(how= How.ID,using="search_src_text")
    public WebElement txt_searchInput;

    @FindBy(how= How.XPATH,using="//*[@text='SEARCH']")
    public WebElement btn_search;

    @FindBy(how= How.XPATH,using="//*[@class='android.widget.ImageButton']")
    public WebElement btn_menu;





}
