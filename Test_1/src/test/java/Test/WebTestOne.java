package Test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import pages.buy;
import pages.home;
import pages.pick_GC;
import pages.search;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class WebTestOne {
    private WebDriver driver;
    home ObjLogin;
    search ObjSerach;
    pick_GC ObjPick;
    buy ObjBuy;

    @Before
    public void setup() throws Exception {
        String type = getData("browserType");
        if (type.equals("Chrome")) {
            String pathToChromeDriver = "lib/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            driver = new ChromeDriver();
        } else if (type.equals("FF")) {
            System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        String Url=getData("URL");
        driver.navigate().to(Url);
        driver.manage().window().maximize();
    }

    @Test
    public void TestOne() {
        ObjLogin = new home(driver);
        ObjLogin.loginToBuyMe("Rotem", "008Lambada", "008Lambada",
                "Rotem.galam@gmail.com");
    }

    @Test
    public void TestTwo() {
        ObjSerach = new search(driver);
        ObjSerach.DoSearch();
    }

    @Test
    public void TestThree() {
        driver.navigate().to("https://buyme.co.il/search?budget=1&category=16&region=13");
        ObjPick = new pick_GC(driver);
        ObjPick.PickGC("10");
        ObjBuy = new buy(driver);
        ObjBuy.Buy("moshe", "David", "D:/cat.jpg", "rotem.galam@gmail.com",
                "0523146427", "0523146428");
    }


    private static String getData(String keyName) throws Exception {
        String xmlFilePath = "data.xml";
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}