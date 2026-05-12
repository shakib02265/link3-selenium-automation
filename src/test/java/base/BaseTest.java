package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.PDFUtil;
import utils.HTMLUtil;
import utils.DashboardWriter;
import utils.ScreenshotUtil;
import utils.CSVUtil;
import utils.VideoUtil;



public class BaseTest {



    public WebDriver driver;




    @BeforeMethod
    public void setup(

            Method method

    ) throws Exception {




        WebDriverManager
                .chromedriver()
                .setup();




        ChromeOptions options =
                new ChromeOptions();




        options.addArguments(

                "--remote-allow-origins=*"
        );




        driver =

                new ChromeDriver(
                        options
                );




        driver.manage()
                .timeouts()
                .implicitlyWait(

                        Duration.ofSeconds(10)
                );




        driver.manage()
                .window()
                .maximize();




        // video name = test method name


        VideoUtil.startRecord(

                method.getName()
        );




        // open Link3


        driver.get(

                "https://www.link3.net/"
        );




        System.out.println(

                "Website opened."
        );
    }




    @AfterMethod(alwaysRun = true)
    public void tearDown(

            ITestResult result

    ) throws Exception {




        String testName =

                result.getName();




        String status =

                result.isSuccess()

                        ?

                        "PASSED"

                        :

                        "FAILED";




        try {



            // screenshot


            if(
                    driver != null
            ){

                ScreenshotUtil.capture(

                        driver,

                        testName
                );
            }




            // pdf


            PDFUtil.create(

                    testName,

                    status
            );




            // html


            HTMLUtil.create(

                    testName,

                    status
            );




            // csv


            CSVUtil.create(

                    testName,

                    status
            );




            // dashboard


            DashboardWriter.addResult(

                    result.isSuccess()
            );



        }

        catch(Exception e){


            e.printStackTrace();
        }




        // stop video


        try{


            VideoUtil.stopRecord();

        }

        catch(Exception e){


            e.printStackTrace();
        }




        // close browser


        if(
                driver != null
        ){

            driver.quit();
        }




        System.out.println(

                "Browser closed."
        );
    }

}