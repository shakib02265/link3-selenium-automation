package utils;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;



public class HTMLUtil {



    private static int total = 0;

    private static int passed = 0;

    private static int failed = 0;

    private static String rows = "";




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
        ){

            folder.mkdir();
        }




        total++;




        if(
                status.equals("PASSED")
        ){

            passed++;
        }

        else{

            failed++;
        }




        String color = "#00d26a";



        if(
                status.equals("FAILED")
        ){

            color = "#ff4d4f";
        }




        rows +=


                "<tr>"

                +

                "<td>"+total+"</td>"

                +

                "<td>"+testName+"</td>"

                +

                "<td style='color:"+color+";font-weight:bold'>"

                +

                status

                +

                "</td>"

                +

                "<td>"+LocalDateTime.now()+"</td>"

                +

                "</tr>";




        int rate =

                (passed*100)/total;




        FileWriter writer =

                new FileWriter(

                        "reports/TestReport.html"
                );




        String html =


                "<!DOCTYPE html>"

                +

                "<html>"

                +

                "<head>"

                +

                "<title>Link3 QA Dashboard</title>"



                +

                "<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>"



                +

                "<style>"



                +

                "body{"

                +

                "margin:0;"

                +

                "font-family:Arial;"

                +

                "background:#eef4ff;"

                +

                "}"


                +

                ".header{"

                +

                "background:linear-gradient(90deg,#0052cc,#00a3ff);"

                +

                "color:white;"

                +

                "padding:30px;"

                +

                "font-size:32px;"

                +

                "font-weight:bold;"

                +

                "}"


                +

                ".container{padding:30px;}"


                +

                ".cards{"

                +

                "display:flex;"

                +

                "gap:20px;"

                +

                "flex-wrap:wrap;"

                +

                "}"


                +

                ".card{"

                +

                "background:white;"

                +

                "width:220px;"

                +

                "padding:25px;"

                +

                "border-radius:18px;"

                +

                "box-shadow:0 8px 20px rgba(0,0,0,.08);"

                +

                "}"


                +

                ".number{"

                +

                "font-size:34px;"

                +

                "font-weight:bold;"

                +

                "margin-top:10px;"

                +

                "color:#0052cc;"

                +

                "}"


                +

                ".charts{"

                +

                "display:grid;"

                +

                "grid-template-columns:1fr 1fr;"

                +

                "gap:25px;"

                +

                "margin-top:40px;"

                +

                "}"


                +

                ".chart-box{"

                +

                "background:white;"

                +

                "padding:20px;"

                +

                "border-radius:18px;"

                +

                "box-shadow:0 8px 20px rgba(0,0,0,.08);"

                +

                "height:320px;"

                +

                "}"


                +

                "canvas{"

                +

                "max-height:250px;"

                +

                "}"


                +

                ".table-box{"

                +

                "background:white;"

                +

                "margin-top:40px;"

                +

                "padding:20px;"

                +

                "border-radius:18px;"

                +

                "box-shadow:0 8px 20px rgba(0,0,0,.08);"

                +

                "}"


                +

                "table{"

                +

                "width:100%;"

                +

                "border-collapse:collapse;"

                +

                "}"


                +

                "th{"

                +

                "background:#0052cc;"

                +

                "color:white;"

                +

                "}"


                +

                "th,td{"

                +

                "padding:15px;"

                +

                "border-bottom:1px solid #ddd;"

                +

                "}"


                +

                "tr:hover{background:#f4f9ff;}"



                +

                "</style>"

                +

                "</head>"



                +

                "<body>"



                +

                "<div class='header'>"

                +

                "LINK3 AUTOMATION DASHBOARD"

                +

                "</div>"



                +

                "<div class='container'>"



                +

                "<div class='cards'>"



                +

                "<div class='card'>Total<div class='number'>"+total+"</div></div>"

                +

                "<div class='card'>Passed<div class='number'>"+passed+"</div></div>"

                +

                "<div class='card'>Failed<div class='number'>"+failed+"</div></div>"

                +

                "<div class='card'>Success<div class='number'>"+rate+"%</div></div>"



                +

                "</div>"



                +

                "<div class='charts'>"



                +

                "<div class='chart-box'><canvas id='chart1'></canvas></div>"

                +

                "<div class='chart-box'><canvas id='chart2'></canvas></div>"

                +

                "<div class='chart-box'><canvas id='chart3'></canvas></div>"

                +

                "<div class='chart-box'><canvas id='chart4'></canvas></div>"



                +

                "</div>"



                +

                "<div class='table-box'>"

                +

                "<table>"

                +

                "<tr>"

                +

                "<th>#</th>"

                +

                "<th>Test Case</th>"

                +

                "<th>Status</th>"

                +

                "<th>Execution Time</th>"

                +

                "</tr>"

                +

                rows

                +

                "</table>"

                +

                "</div>"



                +

                "</div>"



                +

                "<script>"



                +

                "const data=["+passed+","+failed+"];"



                +

                "new Chart(chart1,{type:'doughnut',data:{labels:['Pass','Fail'],datasets:[{data:data}]}});"



                +

                "new Chart(chart2,{type:'bar',data:{labels:['Pass','Fail'],datasets:[{data:data}]}});"



                +

                "new Chart(chart3,{type:'line',data:{labels:['Pass','Fail'],datasets:[{data:data}]}});"



                +

                "new Chart(chart4,{type:'polarArea',data:{labels:['Pass','Fail'],datasets:[{data:data}]}});"



                +

                "</script>"



                +

                "</body>"

                +

                "</html>";




        writer.write(
                html
        );



        writer.close();
    }

}