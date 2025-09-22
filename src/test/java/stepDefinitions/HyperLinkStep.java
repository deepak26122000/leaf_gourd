package stepDefinitions;

import io.cucumber.java.en.*;
import pages.HyperLinkPage;

public class HyperLinkStep {
    HyperLinkPage hyperLinkPage;

    @Given("User click on Element")
    public void user_click_on_element() {
        hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.clickOnElementMenu();
    }

    @And("User click on HyperLink")
    public void user_click_on_hyper_link() {
        hyperLinkPage.clickOnHyperlinkMenu();

    }

    @And("Take User to dashboard")
    public void take_user_to_dashboard() {
        hyperLinkPage.clickToDashboard();
    }

    @And("Find User destination")
    public void find_user_destination() {
        String destination = hyperLinkPage.getLinkDestination();
        System.out.println(destination);

    }

    @And("Use Checks  is it broken link")
    public void use_checks_is_it_broken_link() throws Exception {
        int responseCode = hyperLinkPage.checkBrokenLink();
        if (responseCode >= 400) {
            System.out.println("The link is broken! Response code: " + responseCode);
        } else {
            System.out.println("The link is valid. Response code: " + responseCode);
        }
    }

    @And("User Checks is it Duplicate Link")
    public void user_checks_is_it_duplicate_link() {
        hyperLinkPage.clickDuplicateLink();
    }

    @And("User Check Number of Links")
    public void user_check_number_of_links() {
    hyperLinkPage.countAllLinks();
    }

    @Then("User counts Layout links")
    public void user_counts_layout_links() {
        hyperLinkPage.countLayoutLinks();
    }
}
