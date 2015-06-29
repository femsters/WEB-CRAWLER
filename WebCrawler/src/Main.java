import java.io.*;
import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Main {

    public static ArrayList<String> visited;

	public static void main(String[] args) throws IOException {

		String userInput = "http://www.metrostate.edu";
	    //String userInput = "http://jsoup.org/";

		visited = new ArrayList<String>();
		visited.add(userInput);
		crawl(userInput);
	}

	public static void crawl(String x) throws IOException {
		String url = x;
		String a = null;
		String linkAtt = url.replaceAll("http://", "");
		int depth = 6;

		Document doc = Jsoup.connect(url).get();
		String text = doc.text();

		// Separate words (uses spaces for now)
        String[] docWords = text.split(" ");

        for( String word : docWords) {
            //System.out.println(word);
        }

		// get all links and recursively call the crawl method
		Elements tags = doc.select("a[href]");

		ArrayList<String> urls = new ArrayList<String>();

		// Build an arraylist of links
		for(Element e : tags) {
		    //System.out.println(e.absUrl("href"));
		    urls.add(e.absUrl("href"));
		}
		System.out.println("Found " + urls.size() + " potential URLS");

		if(urls.size() < depth)
		    depth = urls.size();

		for (int i = 0; i < depth; i++) {
		        a = urls.get(i);
				System.out.println(a);
				if(shouldVisit(a)) {
				    visited.add(a);
				    System.out.println("CRAWLING: " + a);
				    crawl(a);
				}
		    }
	    }

	private static Boolean shouldVisit(String url) {
	    if(visited.contains(url)) {
	        return false;
	    }
	    return true;
	}

    }
