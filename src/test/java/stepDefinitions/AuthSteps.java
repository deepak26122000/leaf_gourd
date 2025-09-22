package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.*;
import hooks.Hook;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthPage;
import pages.BrowserPage;
import pages.TextBoxpage;
import utils.Util;


public class AuthSteps {
    WebDriver driver;
    WebDriverWait wait;
    String path;
    String sheetname;
    int lastrow;
    AuthPage authpage;
    BrowserPage alert;
    TextBoxpage textpage;

    @Given("User on Auth page")
    public void userAuthPage() {
        authpage = new AuthPage();
        authpage.authLogic();
    }
    @When("User click on Home")
    public void user_click_on_browser() {
        authpage.clickHome();
        authpage.clickAuth();

    }
    @When("User click on basic auth")
    public void user_click_on_basic_auth() {
        authpage.clckBasicAuth();
    }
    //----------------------------------------Browser Page----------------------------------------------
    @Given("User Enter Url")
    public void user_enter_url() {
        alert = new BrowserPage();
        alert.browserLogic();
    }
    @When("User click on Browser")
    public void click_on_alert_popup() {
        alert.clickBrowser();
    }
    @When("Click on Alert popup")
    public void user_is_handling_all_the_popup() {
        alert.clickAlert();
    }
    @Then("User Handle the popup")
    public void user_close_the_browser() {
        alert.clickshow1();
        alert.clickshow2();
        alert.clickshow3();
        alert.clickshow5();
        alert.clickshow5();
        alert.clickshow6();
        alert.clickshow7();
    }
    //-----------------------------------------------TEXT BOX PAGE----------------------------------------------
    @Given("User Click on element")
    public void inputPage() {
        textpage = new TextBoxpage();
        textpage.clickElementandTextBox();
    }
    @When("User enters in the Name field")
    public void user_enters_in_the_name_field() {
        path = "src/Data/testdata.xlsx";
        Util.loadExcel(path);
        sheetname = "Sheet1";
        lastrow = Util.lastRow(sheetname);
        for (int i = 3; i <= lastrow; i++) {
            String name = Util.getData(sheetname, i, 0);
            textpage.enterName(name);
            Util.writeTestData(sheetname, i, 6);
            System.out.println("row " + i + " marked as a used");
        }
    }
    @And("User appends country to the City field")
    public void enterCity() {
        for (int i = 3; i <= lastrow; i++) {
            String city = Util.getData(sheetname, i, 1);
            textpage.enterCity(city);
        }
    }
    @And("User verify the text box")
    public void disableElement() {
        textpage.verifyDisabledBox();
    }
    @And("User clear the text box")
    public void clearText() {
        textpage.clearTextField();
    }
    @And("User retrieve typed text")
    public void retrieveText() {
        textpage.retrieveText();
    }
    @And("User types email and presses Tab")
    public void enterEmailandTab() {
        textpage.enterEmailandTab("deepak@gmail.com");
    }
    @And("User types about in the About Yourself field")
    public void user_types_about_in_the_about_yourself_field() {
        textpage.enterAbout("My training is going good so far");
    }
    @And("User enter the press")
    public void user_enter_the_press() {
        textpage.pressEnterAndgetText();
    }
    @And("User Click and Confirm Label Position Changes")
    public void user_click_and_confirm_label_position_changes() {
        textpage.confirmLabelPosition();
    }
    @And("User enters dob in the DOB field")
    public void user_enters_dob_in_the_dob_field() {
        textpage.setDobTextField("12/26/2000");
    }

    @When("User enters number in the Number spinner")
    public void user_enters_number_in_the_number_spinner() {
        textpage.enterSpinnerNum("35");
    }
    @When("User enters slider in the Slider field")
    public void user_enters_slider_in_the_slider_field() throws InterruptedException {
        textpage.enterSliderNum("89");
    }
    @When("Click and Confirm Keyboard appears")
    public void user_confirm()  {
        textpage.clickAndConfirm();
    }

}
