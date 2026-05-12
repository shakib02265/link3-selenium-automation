package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class PackagesPage {


    WebDriver driver;

    WebDriverWait wait;



    public PackagesPage(WebDriver driver) {

        this.driver = driver;


        wait =

                new WebDriverWait(

                        driver,

                        Duration.ofSeconds(10)
                );
    }



    // buttons


    By home =
            By.linkText("Home");



    public void open() {

        driver.get(

                "https://www.link3.net/packages"
        );
    }



    public boolean isLoaded() {

        return driver.getCurrentUrl()
                .contains("packages");
    }



    public void clickHome() {


        WebElement element =

                wait.until(

                        ExpectedConditions
                                .elementToBeClickable(

                                        home
                                )
                );



        ((JavascriptExecutor)driver)
                .executeScript(

                        "arguments[0].click();",

                        element
                );
    }

}