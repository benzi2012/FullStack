package SanityTests;

import Extentions.uiActions;
import Extentions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.QuitAction;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

@Listeners(Utilities.listeners.class)
public class nop4YouMobile extends commonOps
{
    @Test(description = "Test 01: Verify Search Results")
    @Description("Test Description: Enter search item and verify its apparel in search results")
    public void test01_VerifySearchResults() throws InterruptedException
    {
        mobileFlows.searchForItem();
       String[] mobileExpItems = new String[]{getData("MobileExp1"),getData("MobileExp2"),getData("MobileExp3")};
        for (int i = 0; i < nop4YouMobileSearchResultsPage.lst_searchResults.size(); i++)
        {
            System.out.println(nop4YouMobileSearchResultsPage.lst_searchResults.get(i).getText());
           assertEquals(mobileExpItems[i],nop4YouMobileSearchResultsPage.lst_searchResults.get(i).getText());
        }
    }
    @Test(description = "Test 02: Verify Currency change")
    @Description("Test Description: Change the currency from USD to Euro")
    public void test02_VerifyCurrencyChange() throws InterruptedException
    {
            uiActions.click(nop4YouMobileHeaderBar.btn_menu);
            uiActions.click(nop4YouMobileLeftSideMenu.btn_settings);
            uiActions.click(nop4YouMobileSettingsPage.currencyField);
        for (int i = 0; i <nop4YouMobileSettingsPage.lst_currency.size(); i++)
        {
            System.out.println(nop4YouMobileSettingsPage.lst_currency.get(i).getText());
            if (nop4YouMobileSettingsPage.lst_currency.get(i).getText().equalsIgnoreCase(getData("expCurrency")))
                uiActions.click(nop4YouMobileSettingsPage.lst_currency.get(i));
        }
        uiActions.click(nop4YouMobileHeaderBar.btn_menu);
        mobileFlows.searchForItem();
        verifications.visibleText(nop4YouMobileSearchResultsPage.priceItem,getData("PriceCurrency"));




    }
}
