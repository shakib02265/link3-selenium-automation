package pages;

import org.openqa.selenium.WebDriver;

public class PayBillPage {

    WebDriver driver;

    public PayBillPage(WebDriver driver){

        this.driver=driver;
    }

    public void open(){

        driver.get(
                "https://selfcare.link3.net/payonline"
        );
    }

}