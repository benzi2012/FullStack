package PageObjects.nop4YouMobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class leftSideMenu
{
    @FindBy(how = How.XPATH, using = "//*[@text='Settings']")
    public WebElement btn_settings;

}
