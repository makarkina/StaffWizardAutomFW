package com.vRoll.autom.steps;

import com.vRoll.autom.forms.EditPayrollCheckDetails;
import com.vRoll.autom.pages.PayrollPage;
import com.vRoll.autom.forms.AddPayrollForm;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class PayrollCreationForOneEmployeeSteps {

    PayrollPage payrollPage;
    AddPayrollForm addPayrollForm;
    EditPayrollCheckDetails editPayrollCheckDetails;

    @Step
    @When("^user creates new payroll on Payroll screen$")
    public void userCreatesNewPayroll() throws Exception {
        //payrollPage.addNewPayroll();
        payrollPage.clickCalculateNewPayroll();
    }

    @Step
    @Then("^user creates new payroll for given dates$")
    public void userCreatesNewPayrollForGivenDates() throws Exception {
        payrollPage.getBeginDateForNewPayroll();
        payrollPage.getEndDateForNewPayroll();
        payrollPage.clickCalculateNewPayroll();
        addPayrollForm.enterDatesToNewPayrollForm();
    }

    @Step
    @When("^user enters (.*), (.*), (.*)$")
    public void user_fills_out_Payroll_form
            (String beginDate, String endDate, String checkDate) throws Exception {
        addPayrollForm.enterDate(
                beginDate, endDate, checkDate);
    }

    @Step
    @When("^user saves new payroll")
    public void userSavesNewPayroll() throws Exception {
        addPayrollForm.saveNewPayroll();
    }

    @Step
    @When("^user refreshes Payroll screen")
    public void userRefreshesPayrollScreen() throws Exception {
        payrollPage.refreshPage();
    }

    @Step
    @Then ("user selects Payroll with (.*) on Payroll screen")
    public void userSelectsPayroll(String givenCheckDate) throws Exception {
        payrollPage.selectPayrollWithGivenCheckDate(givenCheckDate);
    }

    @Step
    @Then ("user verifies check date for (.*)")
    public void userVerifiesCheckDate(String givenCheckDate) throws Exception {
        editPayrollCheckDetails.verifyCheckDate(givenCheckDate);
    }

    @Step
    @Then ("user opens dropdown list on Payroll page")
    public void userOpensDropDownList() throws Exception {
        payrollPage.openDropDownMenuArrow();
    }

    @Step
    @Then ("user selects Payroll Check option")
    public void userSelectsPayrollCheck() throws Exception {
         payrollPage.selectPayrollChecksOption();
    }

    @Step
    @Then ("user creates new payroll for given dates depending on (.*)")
    public void userCreatesNewPayrollForGivenDates(String payFrequency) throws Exception {
        //payrollPage.createNewPayrollForGivenDates(payFrequency);
    }

}
