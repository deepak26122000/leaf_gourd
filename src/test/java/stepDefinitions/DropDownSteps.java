package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DropdownPage;

public class DropDownSteps {
    DropdownPage ddsPage;

    @Given("click on the element")
    public void click_on_the_element() {
        ddsPage = new DropdownPage();
        ddsPage.clickElement1();

    }

    @When("click on the dropdown")
    public void click_on_the_dropdown() {
        ddsPage.clickDropdown();
    }

    @And("select your favorite UI Automation tool")
    public void select_your_favorite_ui_automation_tool() {
    ddsPage.selectTool();
    }

    @And("Choose your preferred country")
    public void choose_your_preferred_country() {
    ddsPage.selectCountry();
    }

    @And("Confirm Cities belongs to Country is loaded")
    public void confirm_cities_belongs_to_country_is_loaded() {
        String city="Bengaluru";
        ddsPage.selectCity(city);

    }

    @And("Choose the Course")
    public void choose_the_course() {
        String course="aws";
    ddsPage.selectCourse(course);
    }

    @And("Choose language randomly")
    public void choose_language_randomly() {
        String lang="Kannada";
        ddsPage.selectRandomLanguage(lang);

    }

    @Then("Select Two irrespective of the language chosen")
    public void select_two_irrespective_of_the_language_chosen() {
        ddsPage.chooseLanguage();
    }


}
