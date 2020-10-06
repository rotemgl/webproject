package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class search {
    WebDriver driver;



    By Price = By.xpath("//span[.='סכום']");

    By Region = By.xpath("//span[.='אזור']");

    By Category = By.xpath("//span[.='קטגוריה']");

    By FindMe = By.partialLinkText("תמצאו לי מתנה");

    public search(WebDriver driver) {

        this.driver = driver;

    }



    //click Price dropdown and pick an option

    public void PriceDrp() {

        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(Price).click();
                driver.findElements(By.className("active-result")).get(1).click();
                break;
            } catch (Exception e) {
                System.out.println("bad seperator-link");
            }
        }
    }

    //click Region dropdown and pick an option
    public void RegionDrp() {

        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(Region).click();
                driver.findElements(By.className("active-result")).get(1).click();
                break;
            } catch (Exception e) {
                System.out.println("bad Regoin");
            }
        }
    }

    //click Category dropdown and pick an option
    public void CategoryDrp() {

        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(Category).click();
                driver.findElements(By.className("active-result")).get(2).click();
                break;
            } catch (Exception e) {
                System.out.println("bad Category");
            }
        }
    }

    public void SearchBtn() {

        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(FindMe).click();
                break;
            } catch (Exception e) {
                System.out.println("bad ");
            }
        }
    }

    public void DoSearch(){
        this.PriceDrp();
        this.RegionDrp();
        this.CategoryDrp();
        this.SearchBtn();
    }
}
