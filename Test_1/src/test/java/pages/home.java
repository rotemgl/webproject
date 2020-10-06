package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class home {
    WebDriver driver;

    By Enter = By.className("seperator-link");

    By Register = By.className("text-btn");

    By Name = By.id("ember1219");

    By Email= By.id("ember1221");

    By Pass = By.id("valPass");

    By PassConf= By.id("ember1225");

    By SubmitBtn= By.xpath("//button[@type='submit']");

    By LoggedIn= By.partialLinkText("https://buyme.co.il/myAccount?tab=gifts_wallet");

    public home(WebDriver driver){

        this.driver = driver;

    }
    //click sign up button

    public void LoginBtn(){

        for (int i = 0; i < 200; i++) {
            try {
                driver.findElement(Enter).click();
                break;
            } catch (Exception e) {
                System.out.println("bad seperator-link");
            }
        }
    }

    //click register button

    public void RegisterBtn(){

        driver.findElement(Register).click();

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(Name).sendKeys(strUserName);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       Assert.assertEquals("Rotem",strUserName);

    }

    //Set password in password textbox

    public void setPass(String strPassword){

        driver.findElement(Pass).sendKeys(strPassword);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("008Lambada",strPassword);

    }

    //Set confirm password in textbox

    public void setPassConf(String strPasswordConf){

        driver.findElement(PassConf).sendKeys(strPasswordConf);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("008Lambada",strPasswordConf);

    }

    //Set Email in Email textbox

    public void setEmail(String strEmail){

        driver.findElement(Email).sendKeys(strEmail);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("Rotem.galam@gmail.com",strEmail);
    }

    //Click on login button

    public void clickLogin(){
        driver.findElement(SubmitBtn).click();
    }
    //assert login state
    public void  CheckLogin(){
        driver.findElement(LoggedIn).click();
        Assert.assertEquals("https://buyme.co.il/myAccount?tab=details",driver.getCurrentUrl());
    }

    //a func to call all functions

    public void loginToBuyMe(String strUserName,String strPassword, String strPasswordConf,
                             String strEmail ){
            this.LoginBtn();
            this.RegisterBtn();
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPass(strPassword);
        this.setPassConf(strPasswordConf);
        // Fill email
        this.setEmail(strEmail);
        //Click Login button

        this.clickLogin();
        this.CheckLogin();
    }

}

