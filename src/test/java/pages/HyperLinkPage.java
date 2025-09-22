package pages;

import hooks.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class HyperLinkPage {
    WebDriver driver;
    WebDriverWait wait;


    private By element = By.xpath("//span[text()='Element']/parent::a");
    private By hyperlink=By.xpath("//span[text()='Hyper Link']/parent::a");
    private By dashboard = By.xpath("(//div[@class='grid formgrid']//a[text()='Go to Dashboard'])[1]");
    private By destinationlink = By.xpath("(//a[@class='ui-link ui-widget'])[2]");
    private By brokenLink = By.xpath("(//div[@class='col-12'])[3]/child::a");
    private By duplicateLink = By.xpath("(//div[@class='grid formgrid']//a[text()='Go to Dashboard'])[2]");
    private By allLinks = By.tagName("a");
    private By layoutLinks = By.xpath("//div[@class='card']//a");

    public HyperLinkPage() {
        this.driver = Hook.driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnElementMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickOnHyperlinkMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hyperlink)).click();
    }

    public void clickToDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboard)).click();
        driver.navigate().back();
    }
    public String getLinkDestination() {
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(destinationlink));
        return link.getAttribute("href");
    }

    public int checkBrokenLink() throws IOException {
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(brokenLink));
        String url = link.getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        return conn.getResponseCode();
    }

    public void clickDuplicateLink() {
        wait.until(ExpectedConditions.elementToBeClickable(duplicateLink)).click();
        driver.navigate().back();
        System.out.println("Duplicate link clicked successfully and navigated back.");
    }

    public void countAllLinks() {
        List<WebElement> links = driver.findElements(allLinks);
        System.out.println("Total number of links on page: "+links.size());
    }

    public void countLayoutLinks() {
        List<WebElement> links = driver.findElements(layoutLinks);
        System.out.println("Number of layout links"+links.size());
    }
}
