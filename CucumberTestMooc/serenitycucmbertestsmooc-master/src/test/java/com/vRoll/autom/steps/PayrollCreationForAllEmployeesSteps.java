package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollForm;
import com.vRoll.autom.forms.EditPayrollCheck;
import com.vRoll.autom.pages.LoginPage;
import com.vRoll.autom.pages.MainPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

import java.text.ParseException;

public class PayrollCreationForAllEmployeesSteps {

    PayrollPage payrollPage;

    @Step
    @Then("^user gets dates for last payroll$")
    public void userGetsLastPayrollDate() throws Exception {
        payrollPage.selectLastPayrollDates();

    }

    @Step
    @When("^user creates next payroll on Payroll screen$")
    public void userCreatesNextPayroll() throws Exception {
        payrollPage.createNextPayroll();
    }

    @Step
    @When("^user gets dates for new payroll$")
    public void userGetsDateForNewPayroll() throws Exception {
        payrollPage.selectNewPayrollDates();
    }

    @Step
    @When("^user gets pay frequency$")
    public void userGetsPayFrequency(){
        payrollPage.getsPayFrequency();
    }

    @Step
    @Then("^user verifies day difference between new payroll and previous one$")
    public void userVerifiesTimeDifference() throws ParseException {
        payrollPage.verifyTimeDifference();
    }

    @Step
    @Then("^user verifies Period Begin Date for new payroll$")
    public void userVerifiesPeriodBeginDate() throws ParseException {
        payrollPage.verifyPeriodBeginDate();
    }

    @Step
    @Then("^user verifies Period End Date for new payroll$")
    public void userVerifiesPeriodEndDate() throws ParseException {
        payrollPage.verifyPeriodEndDate();
    }

    @And("^user verifies a pay frequency for last payroll (.*)$")
    public void userVerifiesPayFrequency(String payFrequency) {
        payrollPage.verifyPayFrequencyForLastPayroll(payFrequency);
    }

    @And("^user verifies a pay frequency for given payroll date (.*)$")
    public void userVerifiesPayFrequencyForGivenPayrollDate(String payFrequency) {
        payrollPage.verifyPayFrequency(payFrequency);
    }
}
