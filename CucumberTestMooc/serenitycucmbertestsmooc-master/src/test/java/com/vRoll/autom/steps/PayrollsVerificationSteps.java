package com.vRoll.autom.steps;

import com.vRoll.autom.pages.MainPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class PayrollsVerificationSteps {

    PayrollPage payrollPage;
    //MainPage mainPage;

    @Step
    @Then("^user verifies a number of payrolls$")
    public void userVerifiesNumberOfEmployees() {
        payrollPage.verifyNumberOfPayrolls();
    }


}
