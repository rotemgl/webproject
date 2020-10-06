package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class pick_GC {
    WebDriver driver;


    By Icon = By.xpath("//a[@href='https://buyme.co.il/supplier/4299680']");

    By ScrollToSum = By.id("ember1265");

    By Sum1 = By.id("ember1266");

    By SumBtnSubmit = By.id("");


    public pick_GC(WebDriver driver){

        this.driver = driver;

    }
    //click buy me kosher icon

    public void IconPress(){

        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(Icon).click();
                break;
            } catch (Exception e) {
                System.out.println("bad Supplier");
            }
        }
    }

    //scroll to enter sum area

    public void ScrollSum(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            try {
                driver.findElement(ScrollToSum);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollToSum);
                Thread.sleep(500);
                break;
            } catch (Exception e) {
                System.out.println("bad");

            }
        }
    }

    //try and enter sum with id number 1

    public void EnterSum1(String strSum){
        for (int i = 0; i < 8; i++) {
            try {
                driver.findElement(Sum1).click();
                driver.findElement(Sum1).sendKeys(strSum);
                driver.findElement(Sum1).sendKeys(Keys.ENTER);
                break;
            } catch (Exception e) {
                System.out.println("001");
            }
        }
    }


    //Get the title of Login Page

    //public String getLoginTitle(){

    //     return    driver.findElement(titleText).getText();

    //}

    public void PickGC(String strSum){

        //pick gift card
        this.IconPress();
        //scroll to sum area
        this.ScrollSum();
        //enter sum and click enter
        this.EnterSum1(strSum);
    }

}

