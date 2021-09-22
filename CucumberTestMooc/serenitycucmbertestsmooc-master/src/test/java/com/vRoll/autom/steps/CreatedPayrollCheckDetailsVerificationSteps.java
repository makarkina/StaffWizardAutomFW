package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollCheckDetails;
import com.vRoll.autom.forms.EditPayrollCheck;
import com.vRoll.autom.forms.EditPayrollCheckDetails;
import com.vRoll.autom.pages.PayrollCheckDetailsPage;
import com.vRoll.autom.pages.PayrollChecksPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class CreatedPayrollCheckDetailsVerificationSteps {

    PayrollPage payrollPage;
    PayrollChecksPage payrollChecksPage;
    PayrollCheckDetailsPage payrollCheckDetailsPage;
    AddPayrollCheckDetails addPayrollCheckDetails;
    EditPayrollCheckDetails editPayrollCheckDetails;
    EditPayrollCheck editPayrollCheck;

    @Step
    @Then("^user opens Edit Check for chosen employee (.*)$")
    public void userOpensEditCheckChosenEmployee(String givenEmployee) {
        payrollChecksPage.clickEditButtonForGivenEmployee(givenEmployee);
    }

    @Step
    @Then("^user opens Payroll Check Details$")
    public void userOpensPayrollCheckDetails() {
        editPayrollCheck.clickCheckDetailsTab();
    }

    @Step
    @Then("^user opens Payroll Check Details for given ED (.*)$")
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
    @Then("^user verifies earning for (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userVerifiesHourlyEarning(String checkDate, String employeeID, String earning,
                                          String state, String hours, String payRate, String amount) {
        editPayrollCheckDetails.verifyHourlyEarning(checkDate, employeeID, earning, state,
                                            hours, payRate, amount);
    }


}
