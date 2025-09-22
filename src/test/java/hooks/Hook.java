package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Util;


public class Hook {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Open Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Util.loadProperty();
        String url=Util.getProperty("url");
        driver.get(url);
    }

   @After
   public void tearDown() {
      if (driver != null) {
          driver.quit();
      }
      System.out.println("Browser closed");
    }
  }


