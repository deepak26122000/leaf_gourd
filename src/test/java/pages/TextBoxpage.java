package pages;

import hooks.Hook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

import java.security.Key;
import java.time.Duration;

public class TextBoxpage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Element']/parent::a")
    private WebElement elementLink;

    @FindBy(xpath = "//span[text()='Text Box']/parent::a")
    private WebElement textboxLink;

    @FindBy(id = "j_idt88:name")
    private WebElement nametextField;

    @FindBy(id = "j_idt88:j_idt91")
    private WebElement cityTextField;

    @FindBy(id = "j_idt88:j_idt93")
    private WebElement disabledTextBox;

    @FindBy(id = "j_idt88:j_idt95")
    private WebElement clearTextBox;

    @FindBy(id = "j_idt88:j_idt97")
    private WebElement retrieveData;

    @FindBy(id = "j_idt88:j_idt99")
    private WebElement emailtextField;

    @FindBy(id = "j_idt88:j_idt101")
    private WebElement abountTextField;

    @FindBy(id = "j_idt106:thisform:age")
    private WebElement pressClick;

    @FindBy(id = "j_idt106:thisform:j_idt110_error-detail")
    private WebElement geterror;

    @FindBy(id = "j_idt106:float-input")
    private WebElement clickLabel;

    @FindBy(id = "j_idt106:j_idt116_input")
    private WebElement dobTextField;

    @FindBy(id = "j_idt106:j_idt118_input")
    private WebElement spinnerTextField;

    @FindBy(id = "j_idt106:slider")
    private WebElement sliderField;

    @FindBy(id = "j_idt106:j_idt122")
    private WebElement keyboardField;


    public TextBoxpage() {
        this.driver = Hook.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public void textboxLogic(){
        Util.loadProperty();
        String url = Util.getProperty("url");
        Hook.driver.get(url);
    }

    public void clickElementandTextBox() {
        wait.until(ExpectedConditions.visibilityOf(elementLink)).click();
        wait.until(ExpectedConditions.visibilityOf(textboxLink)).click();
    }

    public void enterName(String name) {
        nametextField.clear();
        nametextField.sendKeys(name);
    }

    public void enterCity(String city) {
        cityTextField.clear();
        cityTextField.sendKeys(city);
    }

    public void verifyDisabledBox() {
        boolean isdisble = disabledTextBox.isEnabled();
        if (isdisble == true) {
            System.out.println("Text Field id Disabled");
        } else System.out.println("Text Field is Enabled");
    }

    public void clearTextField() {
        clearTextBox.clear();
    }

    public void retrieveText() {
        String text = retrieveData.getAttribute("value");
        System.out.println(text);
    }

    public void enterEmailandTab(String email) {
        emailtextField.sendKeys(email + Keys.TAB);
    }

    public void enterAbout(String text) {
        abountTextField.sendKeys(text);
    }

    public void pressEnterAndgetText() {
      wait.until(ExpectedConditions.visibilityOf(pressClick)).sendKeys(Keys.ENTER);
        String errorText = geterror.getText();
        System.out.println(errorText);
    }

    public void confirmLabelPosition(){
         String before = clickLabel.getAttribute("class");
        clickLabel.click();
        String after=clickLabel.getAttribute("class");
        System.out.println("Label Changed? "+!before.equals(after));
    }

    public void setDobTextField(String dob) {
        dobTextField.sendKeys("12/26/2000");
        dobTextField.sendKeys(Keys.ENTER);
    }
    public void enterSpinnerNum(String num){
        spinnerTextField.sendKeys(num);
    }
    public void enterSliderNum(String num){
        sliderField.sendKeys(num);
    }
    public void keyBoardAppearance(){
        keyboardField.click();
    }
}

