package utils.fileUtils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.browserUtils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Screenshots {

    private static WebDriver driver = DriverFactory.getDriver();
    private static Logger log = Logger.getLogger(Screenshots.class);
    private static File srcFile;

    public static void takeShot(String ScreenName) {
        try {
            Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int sec = cal.get(Calendar.SECOND);
            int min = cal.get(Calendar.MINUTE);
            int date = cal.get(Calendar.DATE);
            int day = cal.get(Calendar.HOUR_OF_DAY);

            try {
                srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                log.info("Camera has been set and ready for taking screenshot");
                String timeStamp = year + "-" + date + "-" + (month + 1) + "-" + day + "-" + min + "-" + sec;
                String systemPath = System.getProperty("user.dir");
                String fullPath = systemPath + "/target/test_output/screen_report" + ScreenName + timeStamp;

                File destFile = new File(fullPath + ".png");
                FileUtils.copyFile(srcFile, destFile);
                log.info("Screenshot for " + ScreenName + " method has been taken and stored");
            } catch (IOException e) {
                log.error("Error occurred " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            log.info("Screenshot for " + ScreenName + " method has NOT been taken due to error!!!");
        }
    }
}
