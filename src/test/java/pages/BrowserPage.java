package pages;


import hooks.Hook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

import java.time.Duration;

public class BrowserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Browser']//parent::a")
    private WebElement browserLink;

    @FindBy(xpath = "//span[text()='Alert']//parent::a")
    private WebElement alertLink;

    @FindBy(xpath = "(//span[text()='Show'])[1]")
    private WebElement show1;

    @FindBy(xpath = "(//span[text()='Show'])[2]")
    private WebElement show2;

    @FindBy(xpath = "(//span[text()='Show'])[3]")
    private WebElement show3;

    @FindBy(xpath = "//span[text()='Dismiss']")
    private WebElement dismissbtn;

    @FindBy(xpath = "(//span[text()='Show'])[4]")
    private WebElement show4;

    @FindBy(xpath = "(//span[text()='Show'])[5]")
    private WebElement show5;

    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement show6;

    @FindBy(xpath = "//span[text()='Yes']/parent::button")
    private WebElement yesBtn;

    @FindBy(xpath = "(//span[text()='Show'])[6]")
    private WebElement show7;

    @FindBy(xpath = "//span[@id='j_idt88:j_idt112_title']/parent::div/a[1]/span")
    private WebElement minmax;

    public BrowserPage() {
        this.driver = Hook.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);

    }
public void browserLogic(){
    Util.loadProperty();
    String url = Util.getProperty("url");
    Hook.driver.get(url);
}

    public void clickBrowser() {
        wait.until(ExpectedConditions.visibilityOf(browserLink)).click();
    }

    public void clickAlert() {
        wait.until(ExpectedConditions.visibilityOf(alertLink)).click();
    }

    public void clickshow1() {
        wait.until(ExpectedConditions.visibilityOf(show1)).click();
        driver.switchTo().alert().accept();
    }

    public void clickshow2() {
        wait.until(ExpectedConditions.visibilityOf(show2)).click();
        driver.switchTo().alert().dismiss();
    }

    public void clickshow3() {
        wait.until(ExpectedConditions.visibilityOf(show3)).click();
        wait.until(ExpectedConditions.visibilityOf(dismissbtn)).click();
    }

    public void clickshow4() {
        wait.until(ExpectedConditions.visibilityOf(show4)).click();

    }

    public void clickshow5() {
        wait.until(ExpectedConditions.visibilityOf(show5)).click();
        Alert pop = Hook.driver.switchTo().alert();
        pop.sendKeys("Deepak");
        pop.accept();
    }

    public void clickshow6() {
        wait.until(ExpectedConditions.visibilityOf(show6)).click();
        wait.until(ExpectedConditions.visibilityOf(yesBtn)).click();

    }

    public void clickshow7() {
        wait.until(ExpectedConditions.visibilityOf(show7)).click();
        wait.until(ExpectedConditions.visibilityOf(minmax)).click();

    }
}
