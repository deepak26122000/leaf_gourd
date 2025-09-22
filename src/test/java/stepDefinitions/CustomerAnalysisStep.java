package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CustomerAnalysisPage;

import java.util.List;

public class CustomerAnalysisStep {
    CustomerAnalysisPage customerAnalysisPage = new CustomerAnalysisPage();

    @Given("User click on the Table")
    public void user_click_on_the_table() {
        customerAnalysisPage.clickOnTable();
    }

    @When("User click on Table link")
    public void user_click_on_table_link() {
        customerAnalysisPage.clickOnTableLink();
    }

    @And("User is on Customer Analytics Table page")
    public void user_is_on_customer_analytics_table_page() {
        System.out.println("User navigated to Customer Analytics Table page");
    }

    @Then("User searches by country")
    public void user_searches_by_country() {
    customerAnalysisPage.getDisplayedCountries("India");
    }
}