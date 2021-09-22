package com.vRoll.autom.steps;

import com.vRoll.autom.pages.CreatePayrollCheckPage;
import com.vRoll.autom.pages.PayrollChecksPage;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;

public class CheckCalculationForAllEmployees2Steps {

    PayrollPage payrollPage;
    CreatePayrollCheckPage createPayrollCheckPage;

    @Step
    @Then("^user creates payroll checks")
    public void userOpensPayrollCheck() throws Exception {
        payrollPage.openDropDownMenuGearForLastPayroll();
        payrollPage.selectCreatePayrollChecks();
        createPayrollCheckPage.clickCreateCheckWithED();
    }
}
