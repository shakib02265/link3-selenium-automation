package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenshotUtil {



    public static void capture(

            WebDriver driver,

            String testName

    ) throws Exception {



        // create folder


        Files.createDirectories(

                Paths.get(

                        "screenshots"
                )
        );




        File source =

                ((TakesScreenshot)driver)

                        .getScreenshotAs(

                                OutputType.FILE
                        );




        Files.copy(

                source.toPath(),

                Paths.get(

                        "screenshots/"
                                + testName
                                + ".png"
                ),

                StandardCopyOption.REPLACE_EXISTING
        );
    }

}