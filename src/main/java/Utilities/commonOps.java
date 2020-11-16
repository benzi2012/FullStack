package Utilities;

import Extentions.uiActions;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonOps extends base
{

    public static String getData (String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println("Error Reading XML File: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public void initBrowser(String browserType) throws FileNotFoundException
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException(("Invalid platform name started"));
        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);



    }
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));

        try
        {
            driver  = new RemoteWebDriver(new URL(getData("mobileUrl")), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not connect to Appium Server, See Details:" + e);
        }

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);

    }
    public static  void initAPI()
    {

        RestAssured.baseURI =getData("url_api");
        httpRequest =RestAssured.given();
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) throws FileNotFoundException
    {
        Platform=PlatformName;

        if(Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));

        else if(Platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(Platform.equalsIgnoreCase("api"))
            initAPI();
        else
            throw new RuntimeException(("Invalid platform name started"));
        managePages.init();
        manageDB.initConnection(getData("dbURL"), getData("dbUser"), getData("dbPassword"));

    }
    @AfterMethod
    public void afterMethod()
    {
        if(Platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else if(Platform.equalsIgnoreCase("mobile"))
            uiActions.click(nop4YouMobileHeaderBar.btn_menu);
    }
    @AfterClass
    public void closeSession()
    {
        manageDB.closeConnection();
        if(!Platform.equalsIgnoreCase("api"))
        driver.quit();


    }
}
