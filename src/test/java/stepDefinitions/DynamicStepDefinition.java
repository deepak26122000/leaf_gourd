package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DynamicPage;

public class DynamicStepDefinition {
    DynamicPage dynamicPage = new DynamicPage();

    @Given("User click on element")
    public void user_click_on_element() {
        dynamicPage.clickOnElement();
    }

    @When("Click on waits")
    public void click_on_waits() {
        dynamicPage.clickOnWaits();
    }

    @And("User check for visibility")
    public void user_check_for_visibility() {
        boolean visible = dynamicPage.checkForVisibility();
        System.out.println("Visibility check: " + visible);
        Assert.assertTrue(visible, "Text 'I am here' should be visible");
    }

    @And("User check for invisibility")
    public void user_check_for_invisibility() {
        boolean invisible = dynamicPage.checkForInvisibility();
        System.out.println("Invisibility check: " + invisible);
        Assert.assertTrue(invisible, "'I am about to hide' should disappear");
    }

    @And("User wait for clickability")
    public void user_wait_for_clickability() {
        boolean clickable = dynamicPage.waitForClickability();
        System.out.println("Second button clickable: " + clickable);
        Assert.assertTrue(clickable, "Second button should be clickable");
    }

    @Then("User wait for text change")
    public void user_wait_for_text_change() {
        dynamicPage.waitForTextChange();
    }

}
