
package pages;
import hooks.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import java.util.Random;
import java.util.Set;
public class CheckBoxPage {
    WebDriver driver;
    private By element = By.xpath("//span[text()='Element']/parent::a");
    private By checkbox = By.xpath("//span[text()='Check Box']/ancestor::a");
    private By basicbox = By.xpath("//div[@id='j_idt87:j_idt89']/child::div[2]");
    private By notificationBox = By.xpath("//div[@id='j_idt87:j_idt91']/child::div[2]");
    private By lang = By.xpath("//table[@id='j_idt87:basic']/tbody/tr/td/div");
    private By tristate = By.xpath("//div[@id='j_idt87:ajaxTriState']/child::div[2]");
    private By toggleswitch = By.xpath("//div[@id='j_idt87:j_idt100']/child::div[2]");
    private By disbled = By.xpath("//div[@id='j_idt87:j_idt102']/child::div[2]");
    private By click = By.xpath("//div[@id='j_idt87:multiple']/descendant::span");
    private By text = By.xpath("(//div[@id='j_idt87:multiple_panel']/div[2])/descendant::li");
    private By multiple = By.xpath("(//div[@id='j_idt87:multiple_panel']/div[2])/descendant::li/div");
    WebDriverWait wait;
    public CheckBoxPage() {
        this.driver = Hook.driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void checkPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox)).click();
    }
    public void clickBesicCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(basicbox)).click();
    }
    public void clickNotificationbox() {
        wait.until(ExpectedConditions.elementToBeClickable(notificationBox)).click();
        System.out.println("Notification check box is checked");
    }
    public void chooseLang() {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lang));
        Random r = new Random();
        int index = r.nextInt(options.size());
        options.get(index).click();
    }
    public void clickTriState() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tristate)).click();
    }
    public void clickToggleSwitch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toggleswitch)).click();
    }
    public void verifyDisabled() {
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(disbled));
        if (option.isEnabled() == true) {
            System.out.println("Check box is disabled");
        }
    }
    public void selectMultiple(Set<String> places) {
        wait.until(ExpectedConditions.elementToBeClickable(click)).click();
        List<WebElement> cityTexts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(text));
        List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(multiple));
        for (int i = 0; i < cityTexts.size(); i++) {
            String city = cityTexts.get(i).getText().trim();
            if (places.contains(city)) {
                checkboxes.get(i).click();
            }
        }
    }
}