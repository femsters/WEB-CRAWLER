package database;

import java.io.*;
import java.text.*;
import java.util.*;

public class URLHistory {

    String SEPARATOR_STR = "||";
    String NEWLINE = System.getProperty("line.separator");

    File historyFile = new File("urls" + ".txt");
    PrintWriter out = new PrintWriter(historyFile, "UTF-8");

    public URLHistory(ArrayList<String> sites) throws IOException {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");

        for( String url : sites) {
            out.write(url + " " + SEPARATOR_STR + " " + dateFormat.format(date) + NEWLINE);
        }

        out.close();

    }

}
