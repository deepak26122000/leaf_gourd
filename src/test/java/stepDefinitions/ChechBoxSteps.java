package stepDefinitions;

import io.cucumber.java.en.*;
import pages.CheckBoxPage;

import java.util.HashSet;
import java.util.Set;

public class ChechBoxSteps {
    CheckBoxPage checKBoxPage;

    @Given("User click on the element")
    public void user_click_on_the_element() {
        checKBoxPage = new CheckBoxPage();
        checKBoxPage.checkPage();
    }

    @When("user click on basic check box")
    public void user_click_on_basic_check_box() {
        checKBoxPage.clickBesicCheckBox();
    }

    @When("User click on the notification checkbox")
    public void user_click_on_the_notification_checkbox() {
        checKBoxPage.clickNotificationbox();
    }

    @When("User select favorite languages")
    public void user_select_favorite_languages() {
        checKBoxPage.chooseLang();
    }

    @When("User click on Tri State Checkbox")
    public void user_click_on_tri_state_checkbox() {
        checKBoxPage.clickTriState();
    }

    @When("User toggle the switch control")
    public void user_toggle_the_switch_control() {
        checKBoxPage.clickToggleSwitch();
    }

    @When("User Verify check box is disabled")
    public void user_verify_check_box_is_disabled() {
        checKBoxPage.verifyDisabled();
    }

    @Then("User select multiple cities")
    public void user_select_multiple_cities() {
        Set<String> place = new HashSet<>();
        place.add("Miami");
        place.add("Paris");
        place.add("Rome");
        System.out.println(place);
        checKBoxPage.selectMultiple(place);
    }
}






