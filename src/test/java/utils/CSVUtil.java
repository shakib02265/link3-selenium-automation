package utils;

import java.io.File;
import java.io.FileWriter;

import java.time.LocalDateTime;

import java.nio.file.Files;
import java.nio.file.Paths;



public class CSVUtil {



    private static int count = 0;




    public static void create(

            String testName,

            String status

    ) throws Exception {




        // create folder automatically


        Files.createDirectories(

                Paths.get(

                        "reports"
                )
        );




        File csvFile =

                new File(

                        "reports/TestReport.csv"
                );




        boolean fileExists =
                csvFile.exists();




        FileWriter writer =

                new FileWriter(

                        csvFile,

                        true
                );




        // write header only first time


        if(
                !fileExists
        ){

            writer.write(

                    "Test No,Test Name,Status,Execution Time\n"
            );
        }




        count++;




        writer.write(

                count

                        +

                        ","

                        +

                        testName

                        +

                        ","

                        +

                        status

                        +

                        ","

                        +

                        LocalDateTime.now()

                        +

                        "\n"
        );




        writer.close();
    }

}