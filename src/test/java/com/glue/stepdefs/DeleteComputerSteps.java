package com.glue.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.helpers.DataGen;
import utils.helpers.WorldHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteComputerSteps {

    public WorldHelper helper;
    public HomePage homePage;

    public DeleteComputerSteps(WorldHelper helper) {this.helper = helper;}

    @Given("I have deleted a computer")
    public void i_have_deleted_a_computer() {
        homePage = helper.getHomePage()
                .clickOnAddComputer()
                .addNewComputer()
                .applyNameFilter(DataGen.getName())
                .selectComputer()
                .deleteComputer();
    }

    @Then("there are no search results")
    public void there_are_no_search_results() {
        homePage = helper.getHomePage();
        assertThat(homePage.getResultsHeader(), is("No computers found"));
        assertThat(homePage.emptyTableText(), is("Nothing to display"));
    }

    @When("I delete the computer")
    public void i_delete_the_computer() {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getName())
                .selectComputer()
                .deleteComputer();
    }

    @Then("^the delete message reads \"([^\"]*)\"$")
    public void theDeleteMessageReads(String expectedMessage) throws Throwable {
        assertThat(homePage.saveWasSuccessful(), is(true));
        assertThat(homePage.getSaveMessage(), is(expectedMessage));
    }

    @When("^I navigate back to the computer$")
    public void iNavigateBackToTheComputer() throws Throwable {
        helper.getHomePage()
                .browserBackToEditPage();
    }

    @And("^I click create$")
    public void iClickCreate() throws Throwable {
        helper.getUpdateComputerPage()
                .clickCreate();
    }

    @Then("^it is handled gracefully$")
    public void itIsHandledGracefully() throws Throwable {
        //ToDo: current bug, implement test once fixed
    }
}