package stepDefinitions;


import io.cucumber.java.en.*;
import pages.RadioButtonPage;

public class RadioButtonStep {
    RadioButtonPage radioButtonPage;
    @Given("user is click on element")
    public void user_is_on_element() {
    radioButtonPage=new RadioButtonPage();
    radioButtonPage.checkPage();
    }

    @When("user click on radio button")
    public void user_click_on_radio_button() {
        radioButtonPage.clickRadio();
    }

    @And("click on the most fvt browser")
    public void click_on_the_most_fvt_browser() {
        radioButtonPage.selectBrowser("chrome");
    }

    @And("user click on unselectable")
    public void user_click_on_unselectable() {
        radioButtonPage.verifyUnselectable();
    }

    @And("user Find the default select radio button")
    public void user_find_the_default_select_radio_button() {
        radioButtonPage.isSelected("Safari");
    }

    @Then("user Select the age group")
    public void user_select_the_age_group() {
        radioButtonPage.setAgegroup();
    }


}
