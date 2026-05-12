package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ReferFriendPage;


public class ReferFriendTest extends BaseTest {


    @Test
    public void testReferFriendPage() {


        ReferFriendPage page =
                new ReferFriendPage(driver);


        page.open();


        Assert.assertTrue(

                driver.getCurrentUrl()
                        .contains("refer")
        );
    }

}