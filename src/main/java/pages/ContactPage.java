package pages;

import org.openqa.selenium.WebDriver;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver){

        this.driver=driver;
    }

    public void open(){

        driver.get(
                "https://www.link3.net/contact-us"
        );
    }

}