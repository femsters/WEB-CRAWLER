import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {

		String userInput = "http://www.metrostate.edu";		

		crawl(userInput);
	}

	public static void crawl(String x) throws IOException {
		String url = x;
		String a = null;
		String linkAtt = url.replaceAll("http://", "");
		int depth = 3;

		Document doc = Jsoup.connect(url).get();

		if (doc.text().contains("edu")) {
			System.out.println(x);
		}

		// get all links and recursively call the crawl method
		Elements tags = doc.select("a[href]");
		Elements link = tags;
		for (int i = 0; i < depth; i++) {		
			if (link.attr("href").contains("linkAtt"))
				a = link.attr("abs:href");
//				System.out.println(a);
				crawl(link.attr("abs:href"));		   
		    }
	    }	
    }
