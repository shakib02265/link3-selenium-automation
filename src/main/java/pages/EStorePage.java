package pages;

import org.openqa.selenium.WebDriver;

public class EStorePage {

    WebDriver driver;

    public EStorePage(WebDriver driver){

        this.driver=driver;
    }

    public void open(){

        driver.get(
                "https://estore.link3.net/"
        );
    }

}