package com.vRoll.autom.steps;

import com.vRoll.autom.forms.EditPayrollCheck;
import com.vRoll.autom.forms.EditPayrollCheckState;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import com.vRoll.autom.pages.PayrollChecksPage;

public class NextPayrollTaxesVerificationSteps {

    //PayrollChecksPage payrollChecksPage;
    EditPayrollCheck editPayrollCheck;
    EditPayrollCheckState editPayrollCheckState;

    @Step
    @Then("^user verifies federal taxes (.*), (.*), (.*), (.*)$")
    public void userVerifiesFederalTaxes (String fedTax, String eeOASDI
            , String eeMedicare, String FUI) throws Exception {
        editPayrollCheck.verifyFedTaxes(fedTax, eeOASDI, eeMedicare, FUI);
    }

    @And("^user verifies state taxes (.*), (.*)$")
    public void userVerifiesStateTaxes(String stateTax, String eeSdiTax) throws Exception {
        editPayrollCheck.clickCheckStatesTab();
        editPayrollCheck.clickEditStateButton();
        editPayrollCheckState.verifyStateTaxes(stateTax, eeSdiTax);

    }

}
