package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AboutPage;

public class AboutTest extends BaseTest {

    @Test
    public void testAboutPage(){

        AboutPage page=
                new AboutPage(driver);

        page.open();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("about")
        );
    }

}