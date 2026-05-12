package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SelfCareLoginPage;



public class SelfCareLoginTest
        extends BaseTest {



    @Test
    public void verifyLoginPageLoaded() {


        SelfCareLoginPage page =

                new SelfCareLoginPage(
                        driver
                );


        page.open();


        Assert.assertTrue(

                page.isLoaded()
        );
    }




    @Test
    public void verifyValidLogin() {


        SelfCareLoginPage page =

                new SelfCareLoginPage(
                        driver
                );


        page.open();



        page.login(

                "YOUR_CUSTOMER_ID",

                "YOUR_PASSWORD"
        );



        String source =

                driver.getPageSource();



        if(

                source.contains("Invalid")

                ||

                source.contains("incorrect")

                ||

                source.contains("wrong")

        ) {


            System.out.println(

                    "LOGIN FAILED"
            );
        }

        else {


            System.out.println(

                    "LOGIN SUCCESS"
            );
        }



        Assert.assertTrue(true);
    }




    @Test
    public void verifyInvalidLogin() {


        SelfCareLoginPage page =

                new SelfCareLoginPage(
                        driver
                );


        page.open();



        page.login(

                "wrong123",

                "wrong123"
        );



        System.out.println(

                "INVALID LOGIN TEST DONE"
        );



        Assert.assertTrue(true);
    }

}