package pl.marekksiazek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.marekksiazek.Main;

public class StartProgramController {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public StartProgramController() {}

    public void startProgram(){
        Runtime runtime = Runtime.getRuntime();

        try{
              Process p = runtime.exec("cmd /c start /min \"\" \"C:\\Path\\to\\program.exe\"");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
//            ex.printStackTrace();
        }
    }
}
