package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollForm;
import com.vRoll.autom.pages.PayrollChecksPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;

public class CheckCalculationForAllEmployeesSteps {

    PayrollPage payrollPage;
    PayrollChecksPage payrollChecksPage;
    //AddPayrollForm addPayrollForm;

    @Step
    @Then("^user gets last payroll date")
    public void userGetsLastCheckDate() throws Exception {
        payrollPage.selectLastPayrollDates();
    }

    @Step
    @Then("^user opens a Payroll Checks screen")
    public void userOpensPayrollCheck() throws Exception {
        payrollPage.openDropDownMenuArrow();
        payrollPage.selectPayrollChecksOption();
    }


    @And("^user calculates all checks$")
    public void userCalculatesAllChecks() throws Exception {
        payrollPage.openDropDownMenuGearForLastPayroll();
        payrollPage.selectCalculateAllChecksOption();
    }


    @Step
    @Then("^user verifies number of calculated checks$")
    public void userVerifiesNumberOfChecks() {
        //payrollCheckDetailsPage.openEditCheckDetails();
    }

    @Step
    @Then("^user verifies number of calculated checks for (.*)")
    public void userVerifiesNumberOfChecks(String allEmployees) throws Exception {
        payrollChecksPage.verifyNumberOfChecks(allEmployees);
    }

    @Then("^user verifies date for each of calculated checks$")
    public void userVerifiesGivenCheckDate() throws Exception {
        payrollPage.openDropDownMenuArrowForLastPayroll();
        payrollPage.selectPayrollChecksOption();
        payrollChecksPage.verifyDateForAllChecks();
    }


}
