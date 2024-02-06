package pl.marekksiazek.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.marekksiazek.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReaderController {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static String userName = System.getenv("USERNAME");
    public static File file = new File("C:\\Users\\" + userName + "\\path\\to\\setup\\file.ini");

    private String firstLine;
    private String secondLine;


    public DataReaderController(){
        setFirstLine(getFirstLine());
        setSecondLine(getSecondLine());
    }

    public String getFirstLine() {
        String line = System.getProperty("line.separator");
        ArrayList<String> strArr = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            firstLine = br.readLine();

            if (firstLine == null) {
                firstLine = userName;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }

        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        String line = System.getProperty("line.separator");
        ArrayList<String> strArr = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            secondLine = br.readLine();

            if (secondLine == null){
                secondLine = "1";
            }
        }catch (IOException e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }
}
