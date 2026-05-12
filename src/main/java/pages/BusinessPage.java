package pages;

import org.openqa.selenium.WebDriver;

public class BusinessPage {

    WebDriver driver;

    public BusinessPage(WebDriver driver){

        this.driver=driver;
    }

    public void open(){

        driver.get(
                "https://www.link3.net/business"
        );
    }

}