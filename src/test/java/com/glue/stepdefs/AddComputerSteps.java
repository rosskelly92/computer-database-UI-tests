package com.glue.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.helpers.DataGen;
import utils.helpers.WorldHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddComputerSteps {

    public WorldHelper helper;
    public HomePage homePage;

    public AddComputerSteps (WorldHelper helper) {this.helper = helper;}

    @When("^I add a new computer with only name field populated$")
    public void iAddANewComputerWithOnlyNameFieldPopulated() throws Throwable {
        homePage = helper.getHomePage()
                .clickOnAddComputer()
                .addComputerNameOnly(DataGen.getName());
    }

    @Then("^the save message reads \"([^\"]*)\" computer name \"([^\"]*)\"$")
    public void theSaveMessageReadsComputerName(String messagePrefix, String messageSuffix) throws Throwable {
        String expectedMessage = messagePrefix + DataGen.getName() + messageSuffix;
        assertThat(homePage.saveWasSuccessful(), is(true));
        assertThat(homePage.getSaveMessage(), is(expectedMessage));
    }

    @When("^I add a new computer with all fields populated$")
    public void iAddANewComputerWithAllFieldsPopulated() throws Throwable {
        homePage = helper.getHomePage()
                .clickOnAddComputer()
                .addNewComputer();
    }

}