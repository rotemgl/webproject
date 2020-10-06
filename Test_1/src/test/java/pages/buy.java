package pages;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class buy {
    WebDriver driver;


    By radiobtn1 = By.xpath("//span[.='למישהו אחר']");

    By GCFor = By.className("ui-grid");

    By Sendto1 = By.xpath("//input[starts-with(@id, 'ember') and contains(@maxlength,'25')]");

    By From1 = By.xpath("//input[starts-with(@id, 'ember') and contains(@data-parsley-required-message,'למי יגידו תודה? שכחת למלא את השם שלך')]");

    By Event= By.xpath("//span[.='לאיזה אירוע?']");

    By Greeting = By.xpath("//input[starts-with(@id, 'ember') and contains" +
            "(@data-parsley-id,'24')]");

    By UpPhoto= By.name("fileUpload");

    By radiobtn2= By.xpath("//input[contains(@data-ember-action, ‘1455’)]");

    By Email= By.xpath("//span[.='במייל']");

    By SMS= By.xpath(("//span[.='ב-SMS']"));

    By Paybtn= By.xpath("//button[@type='submit']");


    public buy(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver = driver;
    }

    //click radio btn

    public void PressRadio1(){
        for (int i = 0; i < 20; i++) {
            try {
                driver.findElement(radiobtn1).click();
                break;
            } catch (Exception e) {
                System.out.println("bad radiobtn top");
            }
        }
    }

    //scroll to details area

    public void Scroll_1(){

        for (int i = 0; i < 10; i++) {
            try {
                driver.findElement(GCFor);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", GCFor);
                Thread.sleep(500);
                break;
            } catch (Exception e) {
                System.out.println("no scroll elment");
            }
        }

    }

    //set send to field(1)

    public void Receiver_1(String strRecName){

        for (int i = 0; i < 8; i++) {
            try {
                driver.findElement(Sendto1).click();
                driver.findElement(Sendto1).sendKeys(strRecName);
                Assert.assertEquals("moshe",strRecName);
                break;
            } catch (Exception e) {
                System.out.println("no receiver element");
            }
        }

    }

    //set send to field(2)


    public void From_1(String strFromName){

        for (int i = 0; i < 8; i++) {
            try {
                driver.findElement(From1).click();
                driver.findElement(From1).sendKeys(strFromName);
                driver.findElement(Sendto1).sendKeys(strFromName);
                Assert.assertEquals("David",strFromName);
                break;
            } catch (Exception e) {
                System.out.println("no From element(1)");
            }
        }

    }

    //set From field(2)



    public void EventPick(){

        for (int i = 0; i < 8; i++) {
            try {
                driver.findElement(Event).click();
                driver.findElements(By.className("active-result")).get(1).click();
                break;
            } catch (Exception e) {
                System.out.println("bad xpath3");
            }
        }

    }

    //Set greeting status

    public void GoodWords() {
        for (int i = 0; i <2; i++) {
            try {
                WebElement Blessing = driver.findElement(Greeting);
                Blessing.click();
                Blessing.sendKeys("wublabadubdub");
                break;
            } catch (Exception e) {
                System.out.println("bad greeting xpath");
            }
        }
    }

    //Try and do photo upload
    public void PhotoUp(String strPhotoFile) {
        for (int i = 0; i < 4; i++) {
            try {
                driver.findElement(UpPhoto).sendKeys(strPhotoFile);
                     break;
            } catch (Exception e) {
                System.out.println("bad photo location");
            }
        }
    }

   //click radio button(send now)

    public void Radiobtn2(){
        for (int i = 0; i < 8; i++) {
            try {
                driver.findElement(radiobtn2).click();
                break;
            } catch (Exception e) {
                System.out.println("bad radiobtn");
            }
        }


    }

    //Set Email in Email textbox

    public void setEmail(String strEmail) {
        for (int i = 0; i < 8; i++) {
            try {
                driver.findElement(Email).click();

                driver.findElement(By.xpath("//input[starts-with(@id, 'ember')" +
                        " and contains(@placeholder,'כתובת המייל של מקבל/ת המתנה')]"))
                        .sendKeys(strEmail);
                driver.findElement(By.xpath("//button[.='שמירה']")).click();
                break;
            } catch (Exception e) {
                System.out.println("bad email");
            }
        }
    }

        //set SMS

        public void setSMS(String strFrom,String strTo){
            for (int i = 0; i < 8; i++) {
                try {
                    driver.findElement(SMS).click();

                    driver.findElement(By.xpath("//input[starts-with(@id, 'ember')" +
                            " and contains(@placeholder,'ספרות בלבד, בלי מקף')]"))
                            .sendKeys(strFrom);
                    driver.findElement(By.xpath("//input[starts-with(@id, 'resendReciver')" +
                            " and contains(@placeholder,'ספרות בלבד, בלי מקף')]"))
                            .sendKeys(strTo);
                    driver.findElement(By.xpath("//button[.='שמירה']")).click();
                    break;
                } catch (Exception e) {
                    System.out.println("bad SMS");
                }
            }
        }

    //click pay button

    public  void Paybtn(){
        for (int i = 0; i < 12; i++) {
            try {
            driver.findElement(Paybtn).click();
            break;
            } catch (Exception e) {

                System.out.println("pay button bad");
            }
        }

    }

    //public String getLoginTitle(){

    //     return    driver.findElement(titleText).getText();

    //}

    public void Buy(String strRecName,String strFromName,String strPhotoFile,
                    String strEmail,String nmbrFrom,String nmbrTo ){
        //press radio button
        this.PressRadio1();
        //scroll
        this.Scroll_1();
        //set receiver name
        this.Receiver_1(strRecName);
        //Fill sender name
        this.From_1(strFromName);
        //Fill sender name(2)
        //pick event
        this.EventPick();
        //scroll
        //pick blessing
        this.GoodWords();
        //Click 2nd radio button
        this.PhotoUp(strPhotoFile);
        this.Radiobtn2();
        // Fill email
        this.setEmail(strEmail);
        //fill sms numbers
        this.setSMS(nmbrFrom,nmbrTo);
        //press pay button
        this.Paybtn();
    }

}

