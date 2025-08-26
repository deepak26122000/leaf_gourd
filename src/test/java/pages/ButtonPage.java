package pages;

import hooks.Hook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import utils.Util;

import java.time.Duration;
import java.util.List;

public class ButtonPage {
    private WebDriver driver;
    private WebDriverWait wait;
    Actions a;
    @FindBy(xpath = "//span[text()='Element']/parent::a")
    private WebElement elementLink;

    @FindBy(xpath = "//span[text()='Button']/parent::a")
    private WebElement buttonLink;

    @FindBy(xpath = "//span[text()='Click']/parent::button")
    private WebElement clickXpath;

    @FindBy(xpath = "//span[text()='Disabled']")
    private WebElement disableXpath;

    @FindBy(xpath = "(//span[text()='Submit'])[1]")
    private WebElement submitLink1 ;

    @FindBy(xpath = "(//span[text()='Save'])")
    private WebElement saveButton1 ;

    @FindBy(xpath = "(//span[text()='Submit'])[2]")
    private WebElement submitLink2 ;

    @FindBy(xpath = "(//span[text()='Success'])[1]")
    private WebElement successbtn1 ;

    @FindBy(xpath = "//span[text()='Image']")
    private WebElement imageBtn ;

    @FindBy(xpath = "//button[contains(@class,'rounded')]")
    private List<WebElement> roundedButtons ;


    public ButtonPage(){
        driver= Hook.driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
        a=new Actions(driver);
    }
    public void  openElement(){
        Util.loadProperty();
       String url=Util.getProperty("url");
       driver.get(url);

    }
    public void clickElement(){
    elementLink.click();
    }
    public void clickButton(){
        buttonLink.click();
    }
    public  void click(){
        wait.until(ExpectedConditions.visibilityOf(clickXpath)).click();

    }
    public void gettitle(){
      String  actualtitle=driver.getTitle();
        System.out.println("Actual Title is "+actualtitle);
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualtitle,expectedTitle);
    }
    public void disableButton(){
        boolean isEnable = wait.until(ExpectedConditions.visibilityOf(disableXpath)).isEnabled();
        if(!isEnable==false){
            System.out.println("Button is disabled");
        }
    }
    public void submitBtnLoc(){
        Point location = submitLink1.getLocation();
        System.out.println("Submit button location X:"+location.getX()+" Y: "+location.getY());
    }
    public void buttonColor(){
        String color = saveButton1.getCssValue("color");
        System.out.println(color);
    }
    public void heightWidthBtn(){
        Dimension size = submitLink2.getSize();
        System.out.println("Submit button - Height: " + size.getHeight() + ", Width: " + size.getWidth());
    }
    public void hoverSuccessButton(){
        a.moveToElement(successbtn1).perform();
    }

    public void clickImage(){
        imageBtn.click();
        imageBtn.click();
        System.out.println("Hidden button clicked successfully!");
    }
    public void countRoundedButtons(){
        System.out.println("Number of rounded buttons: " + roundedButtons.size());
    }



}
