package pl.marekksiazek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.marekksiazek.Main;

import java.io.File;
import java.io.IOException;

public class FileController {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    private String username = System.getProperty("user.name");
    private String pathToDirectory = "C:\\Users\\" + username + "\\path\\to\\directory";
    private String pathToSetupFile = "C:\\Users\\" + username + "\\path\\to\\file\\setup.ini";
    private boolean directoryBarcode = new File(pathToDirectory).exists();
    private boolean setupFile = new File(pathToSetupFile).exists();

    public FileController(){
        if (!directoryBarcode) {
            new File(pathToDirectory).mkdir();
        }

        if (!setupFile) {
            File file = new File(pathToSetupFile);
            boolean result;

            try {
                result = file.createNewFile();
            } catch (IOException e) {
                logger.error(e.getMessage());
//                throw new RuntimeException(e);
            }
        }
    }


}
