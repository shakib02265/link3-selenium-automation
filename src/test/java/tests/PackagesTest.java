package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.PackagesPage;



public class PackagesTest extends BaseTest {



    @Test
    public void verifyPackagesPageLoaded() {


        PackagesPage page =
                new PackagesPage(driver);


        page.open();


        Assert.assertTrue(

                page.isLoaded()
        );
    }



    @Test
    public void verifyHomeButton() {


        PackagesPage page =
                new PackagesPage(driver);


        page.open();


        page.clickHome();


        Assert.assertTrue(

                driver.getCurrentUrl()
                        .contains("link3.net")
        );
    }

}