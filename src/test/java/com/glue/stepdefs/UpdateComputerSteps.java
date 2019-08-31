package com.glue.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UpdateComputerPage;
import utils.helpers.DataGen;
import utils.helpers.WorldHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateComputerSteps {

    public WorldHelper helper;
    public HomePage homePage;
    public UpdateComputerPage updateComputerPage;

    public UpdateComputerSteps(WorldHelper helper) {this.helper = helper;}

    @When("I update the computer")
    public void i_update_the_computer() {
        homePage = helper.getHomePage()
                .applyNameFilter(DataGen.getName())
                .selectComputer()
                .updateAllDetails();
    }

    @Then("^the update message reads \"([^\"]*)\" computer name \"([^\"]*)\"$")
    public void theUpdateMessageReadsComputerName(String messagePrefix, String messageSuffix) throws Throwable {
        String expectedMessage = messagePrefix + DataGen.getUpdatedName() + messageSuffix;
        assertThat(homePage.saveWasSuccessful(), is(true));
        assertThat(homePage.getSaveMessage(), is(expectedMessage));
    }

    @Then("correct values are displayed in edit mode")
    public void correct_values_are_displayed_in_edit_mode() {
        updateComputerPage = helper.getHomePage()
                .selectComputer();
        assertThat(updateComputerPage.getNameValue(), is(DataGen.getName()));
        assertThat(updateComputerPage.getIntroDateValue(), is(DataGen.getIntroDate()));
        assertThat(updateComputerPage.getDiscontDateValue(), is(DataGen.getDiscontDate()));
        assertThat(updateComputerPage.getCompanyNameValue(), is(DataGen.getCompanyName()));
    }

    @Then("updated values are displayed in edit mode")
    public void updated_values_are_displayed_in_edit_mode() {
        updateComputerPage = helper.getHomePage()
                .selectComputer();
        assertThat(updateComputerPage.getNameValue(), is(DataGen.getUpdatedName()));
        assertThat(updateComputerPage.getIntroDateValue(), is(DataGen.getUpdatedIntroDate()));
        assertThat(updateComputerPage.getDiscontDateValue(), is(DataGen.getUpdatedDiscontDate()));
        assertThat(updateComputerPage.getCompanyNameValue(), is(DataGen.getUpdatedCompanyName()));
    }

    @When("^I update the computer to remove name$")
    public void iUpdateTheComputerToRemoveName() throws Throwable {
        updateComputerPage = helper.getHomePage()
                .applyNameFilter(DataGen.getName())
                .selectComputer()
                .updateNameToEmpty();
    }

    @Then("^I receive an update validation warning$")
    public void iReceiveAnUpdateValidationWarning() throws Throwable {
        assertThat("Page Header indicated the wrong page display", updateComputerPage.getH1(), is("Edit computer"));
        assertThat("validation box not displayed", updateComputerPage.validationBoxDisplayed(), is(true));
    }

    @And("^I can proceed with update upon filling the field$")
    public void iCanProceedWithUpdateUponFillingTheField() throws Throwable {
        homePage = helper.getUpdateComputerPage()
                .inputName()
                .clickCreate();
    }
}