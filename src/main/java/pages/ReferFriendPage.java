package pages;

import org.openqa.selenium.WebDriver;

public class ReferFriendPage {

    WebDriver driver;


    public ReferFriendPage(WebDriver driver) {

        this.driver = driver;
    }


    public void open() {

        driver.get(
                "https://selfcare.link3.net/refer-a-friend?v=f"
        );
    }


    public boolean isLoaded() {

        return driver.getCurrentUrl()
                .contains("refer-a-friend");
    }

}