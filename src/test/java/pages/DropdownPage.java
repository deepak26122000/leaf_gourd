package pages;

import hooks.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DropdownPage {
    WebDriver driver;
    WebDriverWait wait;
    Select s;

    @FindBy(xpath = "//span[text()='Element']/parent::a")
    private WebElement elementLink1;

    @FindBy(xpath = "//li[@id='menuform:m_dropdown']/descendant::span")
    private WebElement dropdownLink;

    @FindBy(className = "ui-selectonemenu")
    private WebElement selecttoolLink;

    @FindBy(id = "j_idt87:country_label")
    private WebElement clickselectcountryLink;


    private By selectcityLink = By.id("j_idt87:city_label");

    private By courseField = By.id("j_idt87:auto-complete_input");

    private By languageField=By.id("j_idt87:lang_label");

    private By lang=By.id("j_idt87:value_label");



    public DropdownPage() {
        this.driver = Hook.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }


    public void clickElement1() {
        wait.until(ExpectedConditions.visibilityOf(elementLink1)).click();
    }

    public void clickDropdown() {
        wait.until(ExpectedConditions.visibilityOf(dropdownLink)).click();
    }

    public void selectTool() {
        this.s = new Select(selecttoolLink);
        s.selectByIndex(1);
    }

    public void selectCountry() {
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(clickselectcountryLink));
        countryDropdown.click();

        WebElement indiaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='j_idt87:country_items']/li[@data-label='India']")));
        indiaOption.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(selectcityLink)));
    }

    public void selectCity(String city) {
        WebElement cityDropdown = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(selectcityLink)));
        cityDropdown.click();

        List<WebElement> options = wait.until(
                ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='j_idt87:city_items']/li"))));

        for (WebElement option : options) {
            if (city.equalsIgnoreCase(option.getText().trim())) {
                option.click();
                break;
            }
        }
    }

    public void selectCourse(String course) {
        WebElement courseDropdown = wait.until(ExpectedConditions.elementToBeClickable(courseField));
        courseDropdown.clear();
        courseDropdown.sendKeys(course);

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id='j_idt87:auto-complete_panel']/child::ul/li")));

        for (WebElement option : options) {
            String text = option.getText();
            if (text.equalsIgnoreCase(course)) {
                option.click();
                break;
            }
        }
    }
    public void selectRandomLanguage(String language){
       WebElement languageDropdown=wait.until(ExpectedConditions.elementToBeClickable(languageField));
       languageDropdown.click();
        List<WebElement> options=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='j_idt87:lang_items']/child::li")));
        Random rand=new Random();
        int randIndex = rand.nextInt(options.size());
        options.get(randIndex).click();
        }
        public void chooseLanguage(){
            WebElement langDropdown=wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(lang)));
            langDropdown.click();
            List<WebElement> options=wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='j_idt87:value_items']/child::li"))));
            Random r=new Random();
            int rIndex=r.nextInt(options.size());
            options.get(rIndex).click();
        }
    }
