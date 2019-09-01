package com.glue.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddComputerPage;
import pages.HomePage;
import utils.helpers.DataGen;
import utils.helpers.WorldHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddComputerSteps {

    public WorldHelper helper;
    public HomePage homePage;
    public AddComputerPage addComputerPage;

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

    @When("^I save a new computer without name$")
    public void iSaveANewComputerWithoutName() throws Throwable {
        addComputerPage = helper.getHomePage()
                .clickOnAddComputer()
                .addComputerWithoutName();
    }

    @Then("I receive a validation warning")
    public void i_receive_a_validation_warning() {
        assertThat("Page Header indicated the wrong page display", addComputerPage.getH1(), is("Add a computer"));
        assertThat("validation box not displayed", addComputerPage.validationBoxDisplayed(), is(true));
    }


    @And("^I can proceed upon filling the field$")
    public void iCanProceedUponFillingTheField() throws Throwable {
        homePage = helper.getAddComputerPage()
                .inputName()
                .clickCreate();
    }

    @When("^I cancel a new computer addition$")
    public void iCancelANewComputerAddition() throws Throwable {
        homePage = helper.getHomePage()
                .clickOnAddComputer()
                .cancelAddition();
    }

    @Given("^I have (\\d+) identical computers$")
    public void iHaveIdenticalComputers(int numberToAdd) throws Throwable {
        homePage = helper.getHomePage()
                .addMultipleComputers(numberToAdd);
    }

    @When("^I attempt to add a computer with Introduced date \"([^\"]*)\"$")
    public void iAttemptToAddAComputerWithIntroducedDate(String dateValue) throws Throwable {
        addComputerPage = helper.getHomePage()
                .clickOnAddComputer()
                .addComputerWithIntroDate(dateValue);
    }

    @When("^I attempt to add a computer with Discontinued date \"([^\"]*)\"$")
    public void iAttemptToAddAComputerWithDiscontinuedDate(String dateValue) throws Throwable {
        addComputerPage = helper.getHomePage()
                .clickOnAddComputer()
                .addComputerWithDiscontDate(dateValue);
    }

    @When("^I add a computer with special characters in the name$")
    public void iAddAComputerWithSpecialCharactersInTheName() throws Throwable {
        homePage = helper.getHomePage()
                .clickOnAddComputer()
                .addComputerNameOnly(DataGen.getStrangeName());
    }
}