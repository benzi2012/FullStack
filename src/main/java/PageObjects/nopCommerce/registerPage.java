package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class registerPage
{
    @FindBy(how = How.ID,using = "FirstName")
    public WebElement txt_firstName;

    @FindBy(how = How.ID,using = "LastName")
    public WebElement txt_lastName;

    @FindBy(how = How.ID,using = "Email")
    public WebElement txt_email;

    @FindBy(how = How.ID,using = "Password")
    public WebElement txt_password;

    @FindBy(how = How.ID,using = "ConfirmPassword")
    public WebElement txt_confirmPassword;

    @FindBy(how = How.ID,using = "register-button")
    public WebElement btn_registerButton;

    @FindBy(how = How.CLASS_NAME,using = "result")
    public WebElement txt_registrationConfirmation;


}
