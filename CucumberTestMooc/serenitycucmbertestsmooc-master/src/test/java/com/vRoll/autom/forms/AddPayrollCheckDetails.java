package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddPayrollCheckDetails extends PageObject {

    @FindBy(xpath=
            "//div[@class='row'][2]//div[@meta-widget-name='companyEdm']//button")
    WebElementFacade earnDeductDropDownButton;

    @FindAll(@FindBy(xpath =
            "//div[@class='row'][2]//div[@data-fragment='companyedm_list']//tbody[@class='list-items']//tr"))
    List<WebElement> edFromDropDownList;

    @FindBy(xpath=
            "//div[@class='row'][2]//div[@meta-widget-name='employeeState']//button")
    WebElementFacade stateDropDownButton;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='employeestate_dropdown']//tbody[@class='list-items']//tr[@class='highlight']//td"))
    List<WebElement> stateFromDropDownList;

    @FindBy(xpath=
            "//div[@meta-widget-name='companyEdm']//input[@type='text']")
    WebElementFacade edBox;

    @FindBy(xpath=
            "//div[@meta-widget-name='employeeState']//input[@type='text']")
    WebElementFacade stateBox;

    @FindBy(xpath =
            "//div[@class='row'][5]//div[@class='col-3'][1]//input[@name='hours']")
    WebElementFacade hoursBox;

    @FindBy(xpath =
            "//div[@class='row'][5]//div[@class='col-3'][2]//input[@name='payRate']")
    WebElementFacade payRateBox;

    @FindBy(xpath =
            "//div[@class='row'][5]//div[@class='col-3'][2]//input[@name='payRate']")
    WebElementFacade amountBox;

    @FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//div[@class='btn btn-success btn-sm']")
    WebElementFacade saveButton;

    BasicInteractions basicInteractions;

    public void openEdDropDownMenu() {
        basicInteractions.ifElementDisplayed(earnDeductDropDownButton, basicInteractions);
    }

    public void openStateDropDownMenu() {
        basicInteractions.ifElementDisplayed(stateDropDownButton, basicInteractions);
    }

    public void clickSaveButton() {
        basicInteractions.ifElementDisplayed(saveButton, basicInteractions);
    }

    public void selectEDtype(String edType) {
        basicInteractions.waitingTimeOUT(1500);
        basicInteractions.clickDropDownItemIfBoxEnabled(edType, edBox
                                        , basicInteractions, edFromDropDownList);
    }

    public void selectState(String state) {
        basicInteractions.clickDropDownItemIfBoxEnabled(state, stateBox
                                        , basicInteractions, stateFromDropDownList);
    }

    public void enterHours(String hours) {
        basicInteractions.sendKeyIfElementDisplayed(hours, hoursBox, basicInteractions);
    }

    public void enterPayRate(String payRate) {
        basicInteractions.sendKeyIfElementDisplayed(payRate, payRateBox, basicInteractions);
    }

    public void enterAmount(String amount) {
        basicInteractions.sendKeyIfElementEnabled(amount, amountBox, "amountBox is not available");
    }
}
