package com.vRoll.autom.steps;

import com.vRoll.autom.pages.EmployeePage;
import com.vRoll.autom.pages.MainPage;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Step;

public class EmployeesVerificationSteps {

    EmployeePage employeePage;
    MainPage mainPage;

    @Step
    @Then("^user selects Employees mode on Main page$")
    public void userOpensEmployModeOnMainPage() {
        mainPage.selectEmployeeMode();
    }

    @Step
    @Then("^user verifies a number of employees$")
    public void userVerifiesNumberOfEmployees() {
        //employeePage.verifyNumberOfEmployees(){


    }
}
