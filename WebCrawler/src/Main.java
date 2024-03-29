import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @author Yasser Ganjisaffar <lastname at gmail dot com>
 */
public class Main {

	 public static void main(String[] args) throws Exception {
         String crawlStorageFolder = "/data/crawl/root";
         int numberOfCrawlers = 7;

         CrawlConfig config = new CrawlConfig();
         config.setCrawlStorageFolder(crawlStorageFolder);

         /*
          * Instantiate the controller for this crawl.
          */
         PageFetcher pageFetcher = new PageFetcher(config);
         RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
         RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
         CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

         /*
          * For each crawl, you need to add some seed urls. These are the first
          * URLs that are fetched and then the crawler starts following links
          * which are found in these pages
          */
         /*controller.addSeed("http://www.ics.uci.edu/~lopes/");*/
         for(int i=0;i<5;i++)
         controller.addSeed("http://www.tasty.lk/wadduw/restaurants?sort=p&order=d&page="+i);
         /*controller.addSeed("http://www.ics.uci.edu/~lopes/");
         controller.addSeed("http://www.ics.uci.edu/");*/

         /*
          * Start the crawl. This is a blocking operation, meaning that your code
          * will reach the line after this only when crawling is finished.
          */
         controller.start(MyCrawler.class, numberOfCrawlers);    
         controller.waitUntilFinish();
         System.out.println("Crawler 1 is finished.");
         new DBInsert().insert(MyCrawler.reviewList);
        // System.out.println(MyCrawler.reviewList.size());
 }
}
