package utils;

import java.io.File;
import java.io.FileWriter;

import java.time.LocalDateTime;



public class CSVUtil {



    private static int count = 0;

    private static boolean firstRun = true;




    public static void create(

            String testName,

            String status

    ) throws Exception {




        File folder =

                new File(
                        "reports"
                );



        if(

                !folder.exists()
        ) {

            folder.mkdir();
        }




        FileWriter writer =

                new FileWriter(

                        "reports/TestReport.csv",

                        true
        );




        if(

                firstRun
        ) {


            writer.write(

                    "Test No,Test Name,Status,Execution Time\n"
            );



            firstRun = false;
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