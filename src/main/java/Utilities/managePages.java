package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        nopCommerceUpperBarPage = PageFactory.initElements(driver,PageObjects.nopCommerce.upperBarPage.class);
        nopCommerceRegisterPage = PageFactory.initElements(driver, PageObjects.nopCommerce.registerPage.class);
        nopCommerceHeadermenuPage = PageFactory.initElements(driver,PageObjects.nopCommerce.headerMenu.class);
       nopCommerceCellPhonesPage = PageFactory.initElements(driver,PageObjects.nopCommerce.cellPhonesPage.class);
       nopCommerceShoppingCartPage =PageFactory.initElements(driver,PageObjects.nopCommerce.shoppingCartPage.class);


        //mobile//

        nop4YouMobileHeaderBar =PageFactory.initElements(driver,PageObjects.nop4YouMobile.headerBar.class);
        nop4YouMobileSearchResultsPage= PageFactory.initElements(driver,PageObjects.nop4YouMobile.searchResultsPage.class);
        nop4YouMobileLeftSideMenu =PageFactory.initElements(driver,PageObjects.nop4YouMobile.leftSideMenu.class);
        nop4YouMobileSettingsPage =PageFactory.initElements(driver,PageObjects.nop4YouMobile.settingsPage.class);
    }
}
