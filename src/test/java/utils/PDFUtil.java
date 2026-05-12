package utils;

import java.io.File;

import java.time.LocalDateTime;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.pdfbox.pdmodel.font.PDType1Font;



public class PDFUtil {



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




        PDDocument document =
                new PDDocument();




        PDPage page =
                new PDPage();




        document.addPage(
                page
        );




        PDPageContentStream content =

                new PDPageContentStream(

                        document,

                        page
                );




        content.beginText();




        content.setFont(

                PDType1Font.HELVETICA,

                14
        );




        content.newLineAtOffset(

                50,

                700
        );




        content.showText(

                "Automation Test Report"
        );




        content.newLineAtOffset(

                0,

                -40
        );




        content.showText(

                "Website: https://www.link3.net/"
        );




        content.newLineAtOffset(

                0,

                -30
        );




        content.showText(

                "Test Name: " + testName
        );




        content.newLineAtOffset(

                0,

                -30
        );




        content.showText(

                "Status: " + status
        );




        content.newLineAtOffset(

                0,

                -30
        );




        content.showText(

                "Execution Time: "
                        + LocalDateTime.now()
        );




        content.endText();




        content.close();




        document.save(

                new File(

                        "reports/"
                                + testName
                                + ".pdf"
                )
        );




        document.close();
    }

}