package database;

import java.awt.*;
import java.io.*;
import java.util.*;

public class WordsRecord {

    File words = new File("CrawlerWords" + ".txt");
    PrintWriter out = new PrintWriter(words, "UTF-8");

    public WordsRecord(ArrayList<String> crawledWords) throws IOException {

        updateWordsFile(crawledWords);
        out.close();
        Desktop.getDesktop().open(words);

    }

    private void updateWordsFile(ArrayList<String> crawledWords) {

        String NEWLINE = System.getProperty("line.separator");

        for( String word : crawledWords) {
            out.write(word + NEWLINE);
        }

    }

}
