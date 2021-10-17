package com.vRoll.autom.steps;

import com.vRoll.autom.forms.EditPayrollCheck;
import com.vRoll.autom.forms.EditPayrollCheckDetails;
import com.vRoll.autom.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class PayrollCheckDetailsVerificationSteps {

    PayrollPage payrollPage;
    PayrollChecksPage payrollChecksPage;
    PayrollCheckDetailsPage payrollCheckDetailsPage;
    //EditPayrollCheck editPayrollCheck;

    @Step
    @When("^user opens Payroll Checks$")
    public void userOpensPayrollCheck() throws Exception {
        //payrollPage.openDropDownMenuArrow();
    }

    @Step
    @When("^user selects given employee (.*)$")
    public void userOpensPayrollCheck(String givenEmployee) throws Exception {
        payrollChecksPage.selectGivenEmployee(givenEmployee);
    }

    @Step
    @Then("^user opens Edit Payroll Check Details screen$")
    public void userOpensEditPayrollCheckDetails() throws Exception {
        payrollCheckDetailsPage.openEditCheckDetails();
    }

    @Step
    @Then("^user verifies amount for Earning/Deduction (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void userVerifiesEmployee(String dirDeposit, String childSupport, String levy, String garnishment,
                                     String pension, String hourly, String salary, String overtime) throws Exception {
        payrollCheckDetailsPage.verifyAmount(dirDeposit, childSupport, levy, garnishment, pension,
                                    hourly, salary, overtime);
    }

    @Then("^user opens Payroll Check Details for an employee (.*)$")
    public void opensPayrollCheckDetailsForGivenEmployee(String givenEmployee) {
        payrollChecksPage.openPayrollCheckDetailsForGivenEmployee(givenEmployee);
    }

    @And("^user opens dropdown list for last payroll$")
    public void userOpensDropdownListForLastPayroll() {
        payrollPage.openDropDownMenuArrowForLastPayroll();
    }

    @And("^user verifies EDs in the check (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userVerifiesEDInTheCheck(String dirDeposit, String childSupport, String levy, String garnishment,
                                         String pension, String hourly, String salary, String overtime) {
        payrollCheckDetailsPage.verifyNumberOfExistED(dirDeposit, childSupport, levy, garnishment, pension
                                        , hourly, salary, overtime);
    }
}
