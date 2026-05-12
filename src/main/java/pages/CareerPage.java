package pages;

import org.openqa.selenium.WebDriver;

public class CareerPage {

    WebDriver driver;

    public CareerPage(WebDriver driver){

        this.driver=driver;
    }

    public void open(){

        driver.get(
                "https://www.link3.net/career"
        );
    }

}