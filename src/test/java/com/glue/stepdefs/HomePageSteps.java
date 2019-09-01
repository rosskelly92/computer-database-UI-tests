package com.glue.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.helpers.DataGen;
import utils.helpers.WorldHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageSteps {

    private WorldHelper helper;
    private HomePage homePage;

    public HomePageSteps (WorldHelper helper) {this.helper = helper;}

    @When("I load the HomePage")
    public void i_load_the_HomePage() {
        homePage = helper.getBasePage().loadHomePage();
    }

    @Then("^the page title is \"([^\"]*)\"$")
    public void thePageTitleIs(String title) {
        assertThat(homePage.getTitle(), is(title));
    }

    @When("I search for the computer")
    public void i_search_for_the_computer() {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getName());
    }

    @When("I search for the updated computer")
    public void i_search_for_the_updated_computer() {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getUpdatedName());
    }

    @When("I search for the deleted computer")
    public void i_search_for_the_deleted_computer() {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getName());
    }

    @Then("correct values are displayed in the table")
    public void correct_values_are_displayed_in_the_table() {
        assertThat("Incorrect computer name", homePage.getDisplayedName(), is(DataGen.getName()));
        assertThat("Incorrect intro date", homePage.getDisplayedIntroDate(), is(DataGen.getFormattedIntroDate()));
        assertThat("Incorrect discont date", homePage.getDisplayedDiscontDate(), is(DataGen.getFormattedDiscontDate()));
        assertThat("Incorrect company name", homePage.getDisplayedCompany(), is(DataGen.getCompanyName()));
    }

    @Then("updated values are displayed in the table")
    public void updated_values_are_displayed_in_the_table() {
        assertThat("Incorrect computer name", homePage.getDisplayedName(), is(DataGen.getUpdatedName()));
        assertThat("Incorrect intro date", homePage.getDisplayedIntroDate(), is(DataGen.getFormattedUpdatedIntroDate()));
        assertThat("Incorrect discont date", homePage.getDisplayedDiscontDate(), is(DataGen.getFormattedUpdatedDiscontDate()));
        assertThat("Incorrect company name", homePage.getDisplayedCompany(), is(DataGen.getUpdatedCompanyName()));
    }

    @When("^I search for the original computer$")
    public void iSearchForTheOriginalComputer() throws Throwable {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getName());
    }

    @And("^I search for the special computer$")
    public void iSearchForTheSpecialComputer() throws Throwable {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getStrangeName());
    }

    @Then("^The special computer is displayed in results$")
    public void theSpecialComputerIsDisplayedInResults() throws Throwable {
        assertThat("Incorrect computer name", homePage.getDisplayedName(), is(DataGen.getStrangeName()));

    }
}
