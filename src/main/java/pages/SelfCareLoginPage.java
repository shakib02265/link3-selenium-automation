package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SelfCareLoginPage {


    WebDriver driver;

    WebDriverWait wait;



    public SelfCareLoginPage(WebDriver driver) {

        this.driver = driver;


        wait =

                new WebDriverWait(

                        driver,

                        Duration.ofSeconds(10)
                );
    }



    // locators


    By customerId =
            By.name("customer_id");


    By password =
            By.name("password");


    By loginButton =
            By.xpath(

                    "//button[@type='submit']"
            );



    public void open() {

        driver.get(

                "https://selfcare.link3.net/login"
        );
    }



    public boolean isLoaded() {

        return driver.getCurrentUrl()
                .contains("login");
    }



    public void enterCustomerId(
            String id
    ) {


        WebElement element =

                wait.until(

                        ExpectedConditions
                                .visibilityOfElementLocated(

                                        customerId
                                )
                );


        element.clear();

        element.sendKeys(id);
    }



    public void enterPassword(
            String pass
    ) {


        WebElement element =

                wait.until(

                        ExpectedConditions
                                .visibilityOfElementLocated(

                                        password
                                )
                );


        element.clear();

        element.sendKeys(pass);
    }



    public void clickLogin() {


        WebElement element =

                wait.until(

                        ExpectedConditions
                                .elementToBeClickable(

                                        loginButton
                                )
                );



        ((JavascriptExecutor)driver)
                .executeScript(

                        "arguments[0].click();",

                        element
                );
    }



    public void login(
            String id,
            String pass
    ) {


        enterCustomerId(id);

        enterPassword(pass);

        clickLogin();
    }

}