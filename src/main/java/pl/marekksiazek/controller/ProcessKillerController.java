package pl.marekksiazek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.marekksiazek.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessKillerController {
    // command used to get list of running task
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String TASKLIST = "tasklist";
    // command used to kill a task
    private static final String KILL = "taskkill  /IM ";

    public boolean isProcessRunning(String serviceName) {

        try {
            Process pro = Runtime.getRuntime().exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                if (line.startsWith(serviceName)) {
                    return true;
                }
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }

        return false;
    }

    public static void killProcess(String serviceName) {

        try {
            Runtime.getRuntime().exec(KILL + serviceName + " /T /F");
        } catch (IOException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }

    }

    public static void closeWindow(String serviceName){
        try {
            Runtime.getRuntime().exec(KILL + serviceName);
        } catch (IOException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }
    }
}
