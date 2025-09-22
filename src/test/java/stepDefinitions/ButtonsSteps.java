package stepDefinitions;

import io.cucumber.java.en.*;
import pages.ButtonPage;

import static hooks.Hook.driver;

public class ButtonsSteps {
    ButtonPage btnpage;
    @Given("user launch the application")
    public void user_launch_the_application() {
         btnpage=new ButtonPage();

    }

    @And("User navigated to the button page")
    public void user_navigated_to_the_button_page() {
        btnpage.clickElement();
        btnpage.clickButton();
    }

    @When("User clicks the Click button")
    public void user_clicks_the_click_button() {
        btnpage.click();
    }

    @Then("User should see the page title as Expected Title")
    public void user_should_see_the_page_title_as_expected_title() {
        btnpage.gettitle();
        driver.navigate().back();
    }

    @Then("The Disabled button should be disabled")
    public void the_disabled_button_should_be_disabled() {
    btnpage.disableButton();
    }

    @Then("User should see the position of the Submit button")
    public void then_user_should_see_the_position_of_the_submit_button() {
    btnpage.submitBtnLoc();
    }

    @Then("User should see the Save button color")
    public void user_should_see_the_save_button_color() {
    btnpage.buttonColor();
    }

    @Then("User should see the height and width of the Submit button")
    public void user_should_see_the_height_and_width_of_the_submit_button() {
        btnpage.heightWidthBtn();
    }

    @When("User hovers on the Success button")
    public void user_hovers_on_the_success_button() {
    btnpage.hoverSuccessButton();
    }
    @When("User clicks the Image button")
    public void user_clicks_the_image_button() {
      btnpage.clickImage();
    }

    @Then("User should see the total number of rounded buttons")
    public void user_should_see_the_total_number_of_rounded_buttons() {
      btnpage.countRoundedButtons();
    }

}
