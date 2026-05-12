package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.PayBillPage;

public class PayBillTest extends BaseTest {

    @Test
    public void testPayBillPage(){

        PayBillPage page=
                new PayBillPage(driver);

        page.open();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("pay")
        );
    }

}