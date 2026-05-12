package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;

public class ContactTest extends BaseTest {

    @Test
    public void testContactPage(){

        ContactPage page=
                new ContactPage(driver);

        page.open();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("contact")
        );
    }

}