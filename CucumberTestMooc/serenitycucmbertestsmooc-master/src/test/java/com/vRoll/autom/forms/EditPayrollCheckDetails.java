package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class EditPayrollCheckDetails extends PageObject {

    @FindBy(xpath =
            "//div[@class='card-header bg-lightblue text-white']")
    WebElementFacade pageHeader;

    @FindBy(xpath =
            "//div[@meta-widget-name='checkDate']//input[@name='checkDate']")
    WebElementFacade checkDateBox;

    @FindBy(xpath =
            "//div[@class='form-group state-success']//input[@class='form-control']")
    WebElementFacade employeeIDBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='companyEdm']//input[@type='text']")
    WebElementFacade earnDedBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='employeeState']//input[@type='text']")
    WebElementFacade stateBox;

    @FindBy(xpath =
            "/div[@class='col-4'][3]//input[@readonly='readonly']")
    WebElementFacade typeBox;

   @FindBy(xpath =
            "//div[@meta-widget-name='hours']//input")
    WebElementFacade hoursBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='payRate']//input")
    WebElementFacade payRateBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='rateNumber']//input")
    WebElementFacade rateNumberBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='amount']//input")
    WebElementFacade amountBox;

    @FindAll(@FindBy(xpath = "//div[@class='row']//div[@class='input-group-sm ']"))
    List<WebElement> checkInfoList;

    BasicInteractions basicInteractions;

    public void verifyNewCheckDetails(String state, String amount) {
        basicInteractions.waitingTimeOUT(500);
        basicInteractions.assertEqualsIfElementEnabled(state, stateBox, basicInteractions);
        basicInteractions.assertEqualsIfElementEnabled(amount, amountBox, basicInteractions);
    }

    public void verifyCheckDate(String givenCheckDate){
        basicInteractions.waitingTimeOUT(1000);
        basicInteractions.assertContainsIfElementEnabled(givenCheckDate, checkDateBox, basicInteractions);
    }
    public void verifyEarning(String employeeName, String earnings,
                                    String state, String hours, String payRate, String amount) {
        //basicInteractions.assertContainsIfElementEnabled(employeeName, pageHeader, basicInteractions);
        basicInteractions.assertContainsTextIfElementEnabled(employeeName, pageHeader, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(earnings, earnDedBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(state, stateBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(hours, hoursBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(payRate, payRateBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(amount, amountBox, basicInteractions);
    }
}