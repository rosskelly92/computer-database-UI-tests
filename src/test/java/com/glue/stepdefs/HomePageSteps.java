package com.glue.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.helpers.DataGen;
import utils.helpers.Do;
import utils.helpers.WorldHelper;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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

    @Then("^previous button is disabled$")
    public void previousButtonIsDisabled() throws Throwable {
        assertThat("button was not disabled", homePage.isPreviousBtnDisabled(), is(true));
    }

    @When("^I click next page$")
    public void iClickNextPage() throws Throwable {
        homePage = helper.getHomePage()
                .clickNextPage();
    }

    @Then("^I am on the second page of results$")
    public void iAmOnTheSecondPageOfResults() throws Throwable {
        homePage = helper.getHomePage();
        assertThat("unexpected page navigation", homePage.getPaginationText(), containsString("11 to 20"));
    }

    @And("^I can navigate back to the first page$")
    public void iCanNavigateBackToTheFirstPage() throws Throwable {
        homePage = helper.getHomePage();
        assertThat("previous button was disabled", homePage.isPreviousBtnDisabled(), is(false));
        homePage.clickPreviousPage();
    }

    @Then("^there are (\\d+) search results$")
    public void thereAreSearchResults(int arg0) throws Throwable {
        assertThat("unexpected number of search results", homePage.getPaginationText(), is("Displaying 1 to 4 of 4"));
    }

    @And("^clear the filter$")
    public void clearTheFilter() throws Throwable {
        homePage = helper.getHomePage()
                .clearFilter();
    }

    @Then("^all results are displayed$")
    public void allResultsAreDisplayed() throws Throwable {
        assertThat(homePage.getPaginationText(), not("Displaying 1 to 1 of 1"));
    }

    @Given("^I add multiple unique computers$")
    public void iAddMultipleUniqueComputers() throws Throwable {
        homePage = helper.getHomePage()
                .clickOnAddComputer()
                .addNewComputer()
                .clickOnAddComputer()
                .addComputerNameOnly(DataGen.getUpdatedName());
    }

    @Then("^next button is disabled$")
    public void nextButtonIsDisabled() throws Throwable {
        assertThat("next button was enabled", homePage.isNextBtnDisabled(), is(true));
    }

    @Then("^values from the second filter are displayed in the table$")
    public void valuesFromTheSecondFilterAreDisplayedInTheTable() throws Throwable {
        assertThat("Incorrect computer name", homePage.getDisplayedName(), is(DataGen.getUpdatedName()));
    }

    @And("^pagination text reads \"([^\"]*)\"$")
    public void paginationTextReads(String expectedText) throws Throwable {
        assertThat(homePage.getPaginationText(), is(expectedText));
    }

    @And("^the search results read \"([^\"]*)\"$")
    public void theSearchResultsRead(String expectedHeader) throws Throwable {
        assertThat(homePage.getResultsHeader(), is(expectedHeader));
    }

    @Given("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String filter) throws Throwable {
        homePage = helper.getHomePage()
                .applyNameFilter(filter);
    }

    @When("^I apply \"([^\"]*)\" sort order to \"([^\"]*)\"$")
    public void iApplySortOrderTo(String sortOrder, String columnToSort) throws Throwable {
        homePage = helper.getHomePage()
                .applySorting(columnToSort, sortOrder);
    }

    @Then("^the values are displayed in \"([^\"]*)\" order of \"([^\"]*)\"$")
    public void theValuesAreDisplayedInOrderOf(String sortOrder, String sortedColumn) throws Throwable {

    }
}
