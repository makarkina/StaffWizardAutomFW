package com.vRoll.autom.steps;

import com.vRoll.autom.pages.CompanyPage;
import com.vRoll.autom.forms.CompanyScreen;
import com.vRoll.autom.pages.LoginPage;
import com.vRoll.autom.pages.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;

public class BasicStepDefinitions {

    LoginPage loginPage;
    MainPage mainPage;
    CompanyPage companyPage;
    CompanyScreen companyScreen;

    @Step
    @Given("^user opens the application$")
    public void givenUserOpensTheSite() {
        loginPage.open();
    }

    @Step
    @Given("^user login using (.*) and (.*)$")
    public void givenUserOpensTheSite(String userName, String password) {
        loginPage.typeUserName(userName);
        loginPage.typePassword(password);
        loginPage.clickSubmit();
    }

    @Step
    @When("^user selects Payrolls mode on Main page$")
    public void userSelectsPayrollsOnMainPage(){
        mainPage.selectPayrollsMode();
    }

    @Step
    @Given("^user clicks on Company mode on Main page$")
    public void userClicksOnCompanyMode(){
        mainPage.selectCompaniesMode();
    }

    @Step
    @Given("^user clicks on Companies option$")
    public void userClicksOnCompaniesOption(){
        mainPage.selectCompaniesOption();
    }

    @Step
    @Given("^user selects company by (.*)$")
    public void userSelectsCompanyBy(String companyName){
        companyPage.selectCompanyByName(companyName);
    }

    @Step
    @Given("^user verifies company name$")
    public void userVerifiesCompanyName(){

    }

    @Step
    @Given("^user returns to Main menu$")
    public void userReturnsToMainMenu(){
        mainPage.selectCompaniesMode();
    }

}
