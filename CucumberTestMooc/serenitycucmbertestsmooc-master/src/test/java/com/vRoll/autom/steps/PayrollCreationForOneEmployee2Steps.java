package com.vRoll.autom.steps;

import com.vRoll.autom.forms.AddPayrollForm;
import com.vRoll.autom.pages.PayrollPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class PayrollCreationForOneEmployee2Steps {

    PayrollPage payrollPage;
    AddPayrollForm addPayrollForm;


    @Step
    @When("^user creates new payroll for given dates$")
    public void userEntersPayrollDates() throws Exception {
        payrollPage.getBeginDateForNewPayroll();
        payrollPage.getEndDateForNewPayroll();
        payrollPage.addNewPayroll();
        addPayrollForm.enterDatesToNewPayrollForm();
    }


}
