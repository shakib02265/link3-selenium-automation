package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.EStorePage;

public class EStoreTest extends BaseTest {

    @Test
    public void testEStorePage(){

        EStorePage page=
                new EStorePage(driver);

        page.open();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("estore")
        );
    }

}