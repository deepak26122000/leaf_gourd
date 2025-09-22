package pages;

import hooks.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By element = By.xpath("//span[text()='Element']/parent::a");
    private By waitsMenu = By.xpath("//span[text()='Waits']/parent::a");

    private By visibleButton = By.xpath("//button[@id='j_idt87:j_idt89']");
    private By iamHereText = By.xpath("//span[text()='I am here']");

    private By invisibilityButton = By.xpath("//button[@id='j_idt87:j_idt92']//span[text()='Click']");
    private By disappearingText = By.xpath("//span[text()='I am about to hide']");

    private By firstButton = By.xpath("//span[text()='Click First Button']");
    private By secondButton = By.xpath("//span[text()='Click Second']");

    private By textElementclick = By.xpath("//button[@id='j_idt87:j_idt98']/span");
    private By textElement = By.xpath("//span[text()='I am going to change!']");
    private By changed=By.xpath("//span[text()='Did you notice?']");


    public DynamicPage() {
        this.driver = Hook.driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void clickOnElement() {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickOnWaits() {
        wait.until(ExpectedConditions.elementToBeClickable(waitsMenu)).click();
    }

    public boolean checkForVisibility() {
        wait.until(ExpectedConditions.elementToBeClickable(visibleButton)).click();
        WebElement displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(iamHereText));
        return displayed.isDisplayed();
    }

    public boolean checkForInvisibility() {
        wait.until(ExpectedConditions.elementToBeClickable(invisibilityButton)).click();
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(disappearingText));
    }

    public boolean waitForClickability() {
        wait.until(ExpectedConditions.elementToBeClickable(firstButton)).click();
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(secondButton));
        return btn.isDisplayed() && btn.isEnabled();
    }
    public void waitForTextChange() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textElementclick)).click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textElement));
        System.out.println("Change: " + element.getText());
    }

}
