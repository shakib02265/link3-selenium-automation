package utils;

import java.awt.*;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.math.Rational;

import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;



public class VideoUtil
        extends ScreenRecorder {



    private static VideoUtil recorder;

    private String testName;




    public VideoUtil(

            GraphicsConfiguration gc,

            String testName

    ) throws Exception {



        super(

                gc,

                gc.getBounds(),

                new Format(

                        MediaTypeKey,
                        MediaType.FILE,

                        MimeTypeKey,
                        MIME_AVI
                ),

                new Format(

                        MediaTypeKey,
                        MediaType.VIDEO,

                        EncodingKey,
                        ENCODING_AVI_MJPG,

                        CompressorNameKey,
                        ENCODING_AVI_MJPG,

                        DepthKey,
                        24,

                        FrameRateKey,
                        Rational.valueOf(15),

                        QualityKey,
                        1.0f
                ),

                null,

                null,

                new File("videos")
        );



        this.testName = testName;
    }




    @Override
    protected File createMovieFile(

            Format fileFormat

    ) {


        return new File(

                "videos/" + testName + ".avi"
        );
    }




    public static void startRecord(

            String testName

    ) throws Exception {




        File folder =

                new File("videos");



        if(
                !folder.exists()
        ){

            folder.mkdir();
        }




        GraphicsConfiguration gc =

                GraphicsEnvironment

                        .getLocalGraphicsEnvironment()

                        .getDefaultScreenDevice()

                        .getDefaultConfiguration();




        recorder =

                new VideoUtil(

                        gc,

                        testName
                );




        recorder.start();
    }




    public static void stopRecord()

            throws Exception {



        if(
                recorder != null
        ){

            recorder.stop();
        }
    }

}