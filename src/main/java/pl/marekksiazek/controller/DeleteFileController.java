package pl.marekksiazek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.marekksiazek.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileController {

    private static Logger logger = LoggerFactory.getLogger(Main.class);
    DataReaderController dataReaderController = new DataReaderController();
    String userName = dataReaderController.getFirstLine();
    Path pathToSettingsFile = Paths.get("C:\\Users\\" + userName + "\\Path\\To\\the\\files\\examle.txt");

    Path pathToDatabaseFile = Paths.get("C:\\Users\\" + userName + "\\Path\\To\\the\\files\\examle.txt");


    public DeleteFileController(){}


    public void deleteSettingsFile()  {
        try {
            Files.deleteIfExists(pathToSettingsFile);
        } catch (IOException e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    public void deleteDatabaseFile()  {
        try {
            Files.deleteIfExists(pathToDatabaseFile);
        } catch (IOException e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

}
