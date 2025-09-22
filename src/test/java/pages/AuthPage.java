package pages;

import hooks.Hook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

import java.time.Duration;

public class AuthPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Home']//parent::a")
    private WebElement homeLink;

    @FindBy(xpath = "//span[text()='Auth']//parent::a")
    private WebElement authLink;

    @FindBy(xpath = "//span[text()='Basic Auth']")
    private WebElement basicAuthLink;

    public AuthPage() {
        this.driver = Hook.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void authLogic() {
        Util.loadProperty();
        String url = Util.getProperty("urlAuth");
        driver.get(url);

    }

    public void clickHome() {
        wait.until(ExpectedConditions.visibilityOf(homeLink)).click();
    }

    public void clickAuth() {
        wait.until(ExpectedConditions.visibilityOf(authLink)).click();
    }

    public void clckBasicAuth() {
        wait.until(ExpectedConditions.visibilityOf(basicAuthLink)).click();
    }


}
