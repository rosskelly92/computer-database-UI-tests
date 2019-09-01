package utils.fileUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Props {

    private static final Logger log = LogManager.getLogger(Props.class);

    public static String getConfig(String keyName) {

        String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            log.error(e);
        }
        Properties props = new Properties();
        try {
            props.load(fis);
        } catch (IOException e) {
            log.error(e);
        }
        return props.getProperty(keyName);
    }
}
