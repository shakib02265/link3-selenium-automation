package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CareerPage;

public class CareerTest extends BaseTest {

    @Test
    public void testCareerPage(){

        CareerPage page=
                new CareerPage(driver);

        page.open();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("career")
        );
    }

}