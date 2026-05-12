package base;

import java.lang.reflect.Method;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Allure;

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




        // setup chromedriver


        WebDriverManager

                .chromedriver()

                .setup();




        ChromeOptions options =
                new ChromeOptions();




        // GitHub Actions safe


        options.addArguments(

                "--remote-allow-origins=*",

                "--disable-dev-shm-usage",

                "--no-sandbox"
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




        // start video recording


        VideoUtil.startRecord(

                method.getName()
        );




        // open website


        driver.get(

                "https://www.link3.net/"
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




        // screenshot


        if(
                driver != null
        ){

            ScreenshotUtil.capture(

                    driver,

                    testName
            );
        }




        // reports


        PDFUtil.create(

                testName,

                status
        );




        HTMLUtil.create(

                testName,

                status
        );




        CSVUtil.create(

                testName,

                status
        );




        DashboardWriter.addResult(

                result.isSuccess()
        );




        // stop video


        VideoUtil.stopRecord();




        // allure step


        Allure.step(

                "Running test: " + testName
        );




        // screenshot attachment


        try {


            Allure.addAttachment(

                    "Screenshot",

                    Files.newInputStream(

                            Paths.get(

                                    "screenshots/"
                                            + testName
                                            + ".png"
                            )
                    )
            );


        } catch(Exception e){}




        // video attachment


        try {


            Allure.addAttachment(

                    "Video",

                    Files.newInputStream(

                            Paths.get(

                                    "videos/"
                                            + testName
                                            + ".avi"
                            )
                    )
            );


        } catch(Exception e){}




        // pdf attachment


        try {


            Allure.addAttachment(

                    "PDF",

                    Files.newInputStream(

                            Paths.get(

                                    "reports/"
                                            + testName
                                            + ".pdf"
                            )
                    )
            );


        } catch(Exception e){}




        // close browser safely


        if(
                driver != null
        ){

            driver.quit();
        }
    }

}