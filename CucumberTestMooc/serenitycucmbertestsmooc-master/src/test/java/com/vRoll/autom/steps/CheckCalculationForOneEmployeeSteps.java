package com.vRoll.autom.steps;

import com.vRoll.autom.forms.SelectEmployee;
import com.vRoll.autom.pages.PayrollChecksPage;
import com.vRoll.autom.forms.AddPayrollCheckForm;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;
import com.vRoll.autom.pages.PayrollPage;

public class CheckCalculationForOneEmployeeSteps {

    //PayrollPage payrollPage;
    PayrollChecksPage payrollChecksPage;
    AddPayrollCheckForm addPayrollCheckForm;
    SelectEmployee selectEmployee;

    @Step
    @Then("^user opens a Payroll Check form")
    public void userCreatesNewCheckForEmployee() throws Exception {
        payrollChecksPage.addNewCheckForEmployee();
    }

    @Step
    @Then("^user chooses given employee on Select screen (.*)$")
    public void userSelectsAnEmployee(String givenEmployee) throws Exception {
        addPayrollCheckForm.openEmployeeSelect();
        selectEmployee.selectEmployee(givenEmployee);
        addPayrollCheckForm.saveNewCheck();
    }

    @Step
    @Then("^user calculates a new check for chosen employee (.*)$")
    public void userCalculatesCheckForEmployee(String givenEmployee) throws Exception {
        payrollChecksPage.selectGearButtonForGivenEmployee(givenEmployee);
        payrollChecksPage.calculateCheckForEmployee();
    }

    @Step
    @Then("^user verifies calculated check for (.*), (.*), (.*)$")
    public void userVerifiesInfoForCalcCheck
            (String givenEmployee, String grossWages, String netWages) throws Exception {
        payrollChecksPage.selectGivenEmployee(givenEmployee);
        payrollChecksPage.verifyInfoForSingleCheck(givenEmployee, grossWages, netWages);
    }

}
