package pages;

import hooks.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CustomerAnalysisPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By tableMenu = By.xpath("//span[text()='Table']/parent::a");
    private By tableLink = By.xpath("(//span[text()='Table']/parent::a)[2]");
    private By searchBox = By.id("form:j_idt89:globalFilter");
    private By tableRows = By.xpath("(//span[text()='Italy']/parent::td)[1]/following::td//span[@style='vertical-align: middle; margin-left: .5rem']");

    public CustomerAnalysisPage() {
        this.driver = Hook.driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickOnTable() {
        wait.until(ExpectedConditions.elementToBeClickable(tableMenu)).click();
    }

    public void clickOnTableLink() {
        wait.until(ExpectedConditions.elementToBeClickable(tableLink)).click();
    }

    public void getDisplayedCountries(String country) {
        WebElement text = driver.findElement(By.xpath(
                "(//span[text()='"+country+"']/parent::td)[1]/following::td//span[@style='vertical-align: middle; margin-left: .5rem']"));
        System.out.println("Representative "+text.getText());

        WebElement date = driver.findElement(By.xpath(
                "//span[text()='"+country+"']/parent::td/following-sibling::td/child::span[2]/parent::td//following-sibling::td/child::span[text()='Join Date']/parent::td"));
        System.out.println("Joining Date "+date.getText());
    }
}