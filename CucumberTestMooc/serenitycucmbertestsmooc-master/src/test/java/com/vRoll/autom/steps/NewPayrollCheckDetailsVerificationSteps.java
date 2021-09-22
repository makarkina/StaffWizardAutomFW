package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollCheckDetails;
import com.vRoll.autom.forms.EditPayrollCheck;
import com.vRoll.autom.forms.EditPayrollCheckDetails;
import com.vRoll.autom.pages.PayrollCheckDetailsPage;
import com.vRoll.autom.pages.PayrollChecksPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;

public class NewPayrollCheckDetailsVerificationSteps {

    PayrollPage payrollPage;
    PayrollChecksPage payrollChecksPage;
    PayrollCheckDetailsPage payrollCheckDetailsPage;
    AddPayrollCheckDetails addPayrollCheckDetails;
    EditPayrollCheck editPayrollCheck;
    EditPayrollCheckDetails editPayrollCheckDetails;

    @Step
    @Then("^user opens new Payroll Check Details on Edit Payroll Check screen$")
    public void userOpensNewCheckDetailsOnEditPayrollCheck() {
        editPayrollCheck.opensNewCheckDetails();
    }


    @Step
    @Then("^user adds new Payroll Check Detail with (.*), (.*), (.*), (.*)$")
    public void addNewPayrollCheckDetail(String earnDeduction, String state
            , String hours, String payRate) {
        addPayrollCheckDetails.openEdDropDownMenu();
        addPayrollCheckDetails.selectEDtype(earnDeduction);
        addPayrollCheckDetails.openStateDropDownMenu();
        addPayrollCheckDetails.selectState(state);
        addPayrollCheckDetails.enterHours(hours);
        addPayrollCheckDetails.enterPayRate(payRate);
    }

    @Step
    @Then("^user saves new Payroll Check Details$")
    public void userSavesNewPayrollCheckDetails() {
        addPayrollCheckDetails.clickSaveButton();
    }


    @Step
    @Then("^user verifies added check details for (.*), (.*)$")
    public void userVerifiesNewCheckDetails(String state, String amount) {
        editPayrollCheckDetails.verifyNewCheckDetails(state, amount);
    }
}