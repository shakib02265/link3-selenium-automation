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




        VideoUtil.startRecord(

                method.getName()
        );




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




        // create files


        ScreenshotUtil.capture(

                driver,

                testName
        );




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




        VideoUtil.stopRecord();




        // IMPORTANT:
        // add test name


        Allure.step(

                "Running test: " + testName
        );




        // screenshot


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




        // video


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




        // pdf


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




        if(
                driver != null
        ){

            driver.quit();
        }
    }

}