package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditPayrollCheckDetails extends PageObject {

    @FindBy(xpath =
            "//div[@class='row'][1]//div[@class='col-2'][1]//input[@readonly='readonly']")
    WebElementFacade checkDateBox;

    @FindBy(xpath =
            "//div[@class='row'][1]//div[@class='col-2'][2]//input[@readonly='readonly']")
    WebElementFacade employeeIDBox;

    @FindBy(xpath =
            "//div[@class='row'][2]//div[@meta-widget-name='companyEdm']//input[@type='text']")
    WebElementFacade earnDedBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='employeeState']//input[@type='text']")
    WebElementFacade stateBox;

    @FindBy(xpath =
            "/div[@class='col-4'][3]//input[@readonly='readonly']")
    WebElementFacade typeBox;

    @FindBy(xpath =
            "//div[@class='row'][1]//div[@class='col-3'][2]//input[@readonly='readonly']")
    WebElementFacade lastNameBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='hours']//input")
    WebElementFacade hoursBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='payRate']//input")
    WebElementFacade payRateBox;

    @FindBy(xpath =
            "//div[@class='row'][5]//div[@class='col-3'][3]//input[@readonly='readonly']")
    WebElementFacade rateNumberBox;

    @FindBy(xpath =
            "//div[@meta-widget-name='amount']//input")
    WebElementFacade amountBox;

    @FindAll(@FindBy(xpath = "//div[@class='row']//div[@class='input-group-sm ']"))
    List<WebElement> checkInfoList;

    BasicInteractions basicInteractions;

    public void verifyNewCheckDetails(String state, String amount) {
        basicInteractions.ifElementDisplayed(amountBox, basicInteractions);
    }

    public void verifyHourlyEarning(String checkDate, String employeeID, String earning,
                                    String state, String hours, String payRate, String amount) {
        amountBox.shouldBeVisible();

        Assert.assertTrue(checkDateBox.getValue().contains(checkDate));
        Assert.assertTrue(employeeIDBox.getValue().contains(employeeID));

        if (earning.equals("Hourly")) {
            /*Assert.assertTrue(earnDedBox.getValue().contains(earning));
            Assert.assertTrue(stateBox.getValue().contains(state));
            Assert.assertTrue(hoursBox.getValue().contains(hours));
            Assert.assertTrue(payRateBox.getValue().contains(payRate));
            Assert.assertTrue(amountBox.getValue().contains(amount));*/
            assertThat(earnDedBox.getAttribute("value"), equalTo(earning));
            assertThat(stateBox.getAttribute("value"), equalTo(state));
            assertThat(hoursBox.getAttribute("value"), equalTo(hours));
            assertThat(payRateBox.getAttribute("value"), equalTo(payRate));
            assertThat(amountBox.getAttribute("value"), equalTo(amount));
        } else {
            Assert.assertTrue(earnDedBox.getValue().contains(earning));
            Assert.assertTrue(stateBox.getValue().contains(state));
            Assert.assertTrue(amountBox.getValue().contains(amount));
        }
    }
}