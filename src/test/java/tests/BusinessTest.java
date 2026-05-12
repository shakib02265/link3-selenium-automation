package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BusinessPage;

public class BusinessTest extends BaseTest {

    @Test
    public void testBusinessPage(){

        BusinessPage page=
                new BusinessPage(driver);

        page.open();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("business")
        );
    }

}