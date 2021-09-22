package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollForm;
import com.vRoll.autom.forms.EditCompanyDetails;
import com.vRoll.autom.pages.MainPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

import java.text.ParseException;

public class PayrollCreationForAllEmployeesSetPeriodSteps {

    MainPage mainPage;
    EditCompanyDetails editCompanyDetails;
    PayrollPage payrollPage;
    AddPayrollForm addPayrollForm;


    @Step
    @Then("^user selects Company mode on Main page$")
    public void userSelectsCompanyMode() throws Exception {
        mainPage.selectCompaniesMode();
    }

    @Then("^user opens Edit Company Details page$")
    public void userOpensEditCompanyDetails() throws Exception {
        mainPage.openEditCompanyDetails();
    }

    @Then("^user selects Pay Frequency as (.*)$")
    public void userSelectsPayFrequency(String payFrequency) throws Exception {
        editCompanyDetails.clickPayFrequencyDropDownButton();
        editCompanyDetails.selectPayFrequency(payFrequency);
    }

    @Then("^user saves updated Pay Frequency$")
    public void userSavePayFrequency() throws Exception {
        editCompanyDetails.clickSaveButton();
    }
}
