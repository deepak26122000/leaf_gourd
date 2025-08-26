package pages;

import hooks.Hook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Util;

import java.time.Duration;

public class DropdownPage {
    WebDriver driver;
    WebDriverWait wait;
    Select s;
    @FindBy(xpath = "//span[text()='Element']/parent::a")
    private WebElement elementLink1;

    @FindBy(xpath = "//li[@id='menuform:m_dropdown']/descendant::span")
    private WebElement dropdownLink;

    @FindBy(className ="ui-selectonemenu")
    private WebElement selecttoolLink;

    public DropdownPage(){
        this.driver= Hook.driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

   public void clickElement1(){
        wait.until(ExpectedConditions.visibilityOf(elementLink1)).click();
   }
    public void clickDropdown(){
        wait.until(ExpectedConditions.visibilityOf(dropdownLink)).click();
    }
    public void selectTool(){
        this.s=new Select(selecttoolLink);
        s.selectByIndex(2);
    }


}
