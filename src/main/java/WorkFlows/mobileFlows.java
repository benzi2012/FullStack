package WorkFlows;

import Extentions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mobileFlows extends commonOps
{
    @Step("Add Item To Cart")
    public static void searchForItem() throws InterruptedException {

        uiActions.click(nop4YouMobileHeaderBar.btn_magnifyingGlass);
        uiActions.updateText(nop4YouMobileHeaderBar.txt_searchInput,getData("SearchInput"));
        uiActions.click(nop4YouMobileHeaderBar.btn_search);


    }
}
