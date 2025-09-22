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

public class RadioButtonPage {
    WebDriver driver;
    WebDriverWait wait;
    private By element = By.xpath("//span[text()='Element']/parent::a");

    private By radiobutton = By.xpath("//li[@id='menuform:m_radio']/descendant::span");

    private By fvtbrowser = By.xpath("//input[@name='j_idt87:console1']/parent::div/parent::div/following::label[position()<2]");

    private By select = By.xpath("(//div[@class='ui-g']/parent::div)[1]//div[@class='ui-g-12 ui-md-4']/label");

    private By isselected = By.xpath("//table[@id='j_idt87:console2']/descendant::td/div//input");

    private By agegroup = By.xpath("//div[@id='j_idt87:age']//div[@class='ui-g']/div//div[@class='ui-radiobutton ui-widget']");


    public RadioButtonPage() {
        this.driver = Hook.driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void checkPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }
    public void clickRadio() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(radiobutton)).click();
    }
    public void selectBrowser(String browser) {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fvtbrowser));
        for (int i = 0; i < options.size(); i++) {
            String text = options.get(i).getText();
            System.out.println("Fvt browser " + text);
            if (text.equalsIgnoreCase(browser)) {
                options.get(i).click();
                break;
            }
        }
    }
    public void verifyUnselectable() {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(select));
        for (int i = 0; i < options.size(); i++) {
            options.get(i).click();
            System.out.println("Is Radio Button Clickable " + options.get(i).isEnabled());
        }
    }
    public void isSelected(String browser) {
        WebElement check=driver.findElement(By.xpath("(//label[text()='"+browser+"'])[2]/parent::td/descendant::div/div/input"));
        System.out.println(check.isSelected());
    }
    public void setAgegroup() {
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(agegroup));
        for (WebElement option : options) {
            boolean check = option.isSelected();
            System.out.println(check);
        }
    }
}
