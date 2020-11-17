package com.blazedemo.steps;

import com.blazedemo.pages.LoginPage;
import com.blazedemo.pages.ResultPage;
import com.blazedemo.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchScenarioSteps {
    LoginPage loginPage;
    SearchPage searchPage;
    ResultPage resultPage;

    @Given("^user opens the site$")
    public void givenUserOpensTheSite() {
        loginPage.open();
    }

    @When("user choose (.*)")
    public void whenGivenUserChoose(String text){
        searchPage.chooseDeparture(text);
    }

    @When("user clicks on ChooseFlight button")
    public void andGivenUserClickOnButton(){
        searchPage.clickChooseFlightButton();
    }

    @Then("user sees Flight list")
    public void thenUserSeesFlightList(){
        Assert.assertTrue(resultPage.isResultDisplayed());
    }

    @Then("(.*) should be displayed")
    public void thenShouldBeDisplayed(String expectedDepCity){
        Assert.assertEquals(resultPage.choosenDepCity(), expectedDepCity);
    }

}
