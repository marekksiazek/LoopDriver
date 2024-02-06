package pl.marekksiazek;

import pl.marekksiazek.controller.*;
import pl.marekksiazek.tray.Tray;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws IOException, InterruptedException {


        boolean run = true;

        FileController fileController = new FileController();
        Tray tray = new Tray();
        DeleteFileController deleteFileController = new DeleteFileController();
        StartProgramController startProgramController = new StartProgramController();
        DataReaderController dataReaderController = new DataReaderController();


        while (run){
            ProcessKillerController processKillerController = new ProcessKillerController();
            String processName = "process name";
            boolean isRunning = processKillerController.isProcessRunning(processName);

            if (isRunning) {
                logger.info("shutdown of the process");
                processKillerController.killProcess(processName);
                TimeUnit.SECONDS.sleep(5);
                if (!isRunning){
                    logger.info("file removal");
                    deleteFileController.deleteSettingsFile();
                    deleteFileController.deleteDatabaseFile();
                    TimeUnit.SECONDS.sleep(2);
                    logger.info("program start");
                    startProgramController.startProgram();
                    TimeUnit.SECONDS.sleep(3);
                    logger.info("Minimizing the program");
                    processKillerController.closeWindow(processName);
                    TimeUnit.MINUTES.sleep(Integer.parseInt(dataReaderController.getSecondLine()));
                }
            }
            else {
                logger.info("file removal");
                deleteFileController.deleteSettingsFile();
                deleteFileController.deleteDatabaseFile();
                TimeUnit.SECONDS.sleep(2);
                logger.info("program start");
                startProgramController.startProgram();
                TimeUnit.SECONDS.sleep(3);
                logger.info("Minimizing the program");
                processKillerController.closeWindow(processName);
                TimeUnit.MINUTES.sleep(Integer.parseInt(dataReaderController.getSecondLine()));
            }
        }
    }
}