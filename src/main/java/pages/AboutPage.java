package pages;

import org.openqa.selenium.WebDriver;

public class AboutPage {

    WebDriver driver;

    public AboutPage(WebDriver driver){

        this.driver=driver;
    }

    public void open(){

        driver.get(
                "https://www.link3.net/about-us"
        );
    }

}