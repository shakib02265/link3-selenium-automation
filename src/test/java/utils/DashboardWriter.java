package utils;

import java.io.File;
import java.io.FileWriter;



public class DashboardWriter {



    private static int total = 0;

    private static int passed = 0;

    private static int failed = 0;




    public static void addResult(

            boolean success

    ) {


        total++;



        if(

                success
        ) {

            passed++;
        }

        else {

            failed++;
        }



        write();
    }




    private static void write() {


        try {


            File folder =

                    new File(
                            "dashboard"
                    );



            if(

                    !folder.exists()
            ) {

                folder.mkdir();
            }




            FileWriter writer =

                    new FileWriter(

                            "dashboard/results.json"
                    );



            String json =

                    "{"

                    +

                    "\"total\":"

                    +

                    total

                    +

                    ","

                    +

                    "\"passed\":"

                    +

                    passed

                    +

                    ","

                    +

                    "\"failed\":"

                    +

                    failed

                    +

                    "}";



            writer.write(

                    json
            );



            writer.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }

    }

}