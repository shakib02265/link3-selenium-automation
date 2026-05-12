package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class HomePage {


    WebDriver driver;

    WebDriverWait wait;



    public HomePage(WebDriver driver) {

        this.driver = driver;


        wait =

                new WebDriverWait(

                        driver,

                        Duration.ofSeconds(15)
                );
    }



    // menu


    By home =
            By.linkText("Home");


    By packages =
            By.linkText("Packages");


    By business =
            By.linkText("Business");


    By aboutUs =
            By.linkText("About Us");


    By payBill =
            By.linkText("Pay Bill");


    By career =
            By.linkText("Career");


    By contactUs =
            By.linkText("Contact Us");



    // package section


    By packageTab =
            By.xpath(

                    "(//a[contains(text(),'Packages')])[2]"
            );



    public boolean isHomeVisible() {


        return wait.until(

                ExpectedConditions
                        .visibilityOfElementLocated(

                                home
                        )
        ).isDisplayed();
    }




    public void clickPackages() {

        click(packages);
    }



    public void clickBusiness() {

        click(business);
    }



    public void clickAboutUs() {

        click(aboutUs);
    }



    public void clickPayBill() {

        click(payBill);
    }



    public void clickCareer() {

        click(career);
    }



    public void clickContactUs() {

        click(contactUs);
    }




    public boolean isPackageTabVisible() {


        scrollHalf();



        WebElement element =

                wait.until(

                        ExpectedConditions
                                .presenceOfElementLocated(

                                        packageTab
                                )
                );



        return element.isDisplayed();
    }




    public void clickPackageTab() {


        scrollHalf();



        WebElement element =

                wait.until(

                        ExpectedConditions
                                .presenceOfElementLocated(

                                        packageTab
                                )
                );



        jsClick(element);
    }




    private void click(
            By locator
    ) {


        WebElement element =

                wait.until(

                        ExpectedConditions
                                .elementToBeClickable(

                                        locator
                                )
                );



        jsClick(element);
    }




    private void scrollHalf() {


        ((JavascriptExecutor)driver)
                .executeScript(

                        "window.scrollTo(0,900);"
                );
    }




    private void jsClick(
            WebElement element
    ) {


        ((JavascriptExecutor)driver)
                .executeScript(

                        "arguments[0].click();",

                        element
                );
    }

}