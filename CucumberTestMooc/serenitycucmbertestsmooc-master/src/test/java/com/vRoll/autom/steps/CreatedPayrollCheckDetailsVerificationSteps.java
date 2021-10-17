package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollCheckDetails;
import com.vRoll.autom.forms.EditPayrollCheck;
import com.vRoll.autom.forms.EditPayrollCheckDetails;
import com.vRoll.autom.pages.PayrollCheckDetailsPage;
import com.vRoll.autom.pages.PayrollChecksPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class CreatedPayrollCheckDetailsVerificationSteps {

    PayrollPage payrollPage;
    PayrollChecksPage payrollChecksPage;
    PayrollCheckDetailsPage payrollCheckDetailsPage;
    EditPayrollCheckDetails editPayrollCheckDetails;
    EditPayrollCheck editPayrollCheck;

    @Step
    @When("^user selects payroll with (.*)$")
    public void userSelectPayrollWithGivenCheckDate(String givenCheckDate) {
        payrollPage.selectPayrollWithGivenDate(givenCheckDate);
    }

    @Step
    @Then("^user verifies (.*) on selected check$")
    public void userVerifiesDateOnSelectedCheck(String givenCheckDate) {
        payrollChecksPage.verifyDateOnSelectedCheck(givenCheckDate);
    }


    @Step
    @Then("^user opens Edit Check for chosen employee (.*)$")
    public void userOpensEditCheckChosenEmployee(String givenEmployee) {
        payrollChecksPage.clickEditButtonForGivenEmployee(givenEmployee);
    }

    @Step
    @Then("^user clicks Payroll Check Details Tab$")
    public void userOpensPayrollCheckDetails() {
        editPayrollCheck.clickCheckDetailsTab();
    }

    @Step
    @Then("^user opens Edit Payroll Check for given ED (.*)$")
    public void userOpensPayrollCheckDetailsForChosenEmployee(String givenED) {
        editPayrollCheck.selectED(givenED);
        editPayrollCheck.clickEditButton();
    }

    @Step
    @Then("^user opens Add Payroll Check Detail form$")
    public void openNewPayrollCheckDetail() {
        payrollCheckDetailsPage.openAddCheckDetails();
    }

    @Step
    @Then("^user selects given ED (.*)$")
    public void userSelectsGivenED(String givenED){
        payrollCheckDetailsPage.selectEarning(givenED);
    }

    @Step
    @Then("^user opens Edit Payroll Check Detail form$")
    public void userOpensPayrollCheckDetail() {
        payrollCheckDetailsPage.openEditCheckDetails();
    }

    @Step
    @Then("^user clicks Save button on Edit Payroll Check screen$")
    public void userClicksSaveOnEditPayrollCheck() {
        editPayrollCheck.clickSaveButton();
    }


    @Step
    @Then("^user verifies earning for (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userVerifiesHourlyEarning(String employeeName, String earning,
                                          String state, String hours, String payRate, String amount) {
        editPayrollCheckDetails.verifyEarning(employeeName, earning, state,
                                            hours, payRate, amount);
    }
}
