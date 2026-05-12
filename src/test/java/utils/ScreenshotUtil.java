package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotUtil {


    public static String capture(
            WebDriver driver,
            String testName
    ) throws Exception {


        File src =
                ((TakesScreenshot)driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );


        String path =
                "screenshots/"
                        + testName
                        + ".png";


        Files.copy(
                src.toPath(),
                new File(path).toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );


        return path;
    }

}