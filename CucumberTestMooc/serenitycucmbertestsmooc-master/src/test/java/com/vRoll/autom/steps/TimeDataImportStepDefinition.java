package com.vRoll.autom.steps;

import com.vRoll.autom.pages.*;
import com.vRoll.autom.forms.CompanyScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;


public class TimeDataImportStepDefinition {
    LoginPage loginPage;
    MainPage mainPage;
    CompanyPage companyPage;
    CompanyScreen companyScreen;
    //EmployeePage employeePage;


    @Step
    @When("^user selects Employees option on Company page$")
    public void userSelectsEmployeesOption(){
        companyPage.clickOnChoosingOptions();
        companyPage.selectEmployeesOption();
    }

    @Step
    @Then("^user selects Payroll checks on Employees page$")
    public void userSelectsPayrollChecks(){
        //employeePage.clickOnChoosingOptions();
        //employeePage.selectPayrollCheck();
    }
}
