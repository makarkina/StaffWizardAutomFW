package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditCompanyDetails extends PageObject {

    @FindBy(css = "#payroll-information-tab")
    WebElementFacade payrollInformationTab;

    @FindBy(xpath = "//div[@meta-widget-name='payFrequency']//button[@data-formname='forms/enum/payfreq']")
    WebElementFacade payFrequencyDropDownButton;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='payfreq']//tbody[@class='list-items']//tr"))
    List<WebElement> payFrequencyDropDownList;

    @FindBy(xpath =
            "//div[@class='d-flex mb-2 mt-2']//div[@class='btn btn-success btn-sm save-btn']")
    WebElementFacade saveButton;

    BasicInteractions basicInteractions;

    public void clickPayFrequencyDropDownButton() {
        basicInteractions.ifElementEnabled(payFrequencyDropDownButton, basicInteractions);
    }

    public void selectPayFrequency(String payFrequency) {
        basicInteractions.clickIfElementEqualsToParameter(payFrequency
                                    , payFrequencyDropDownList);
    }

    public void clickSaveButton() {
        basicInteractions.waitingTimeOUT(1000);
        saveButton.shouldBeCurrentlyVisible();
        basicInteractions.ifElementEnabled(saveButton, basicInteractions);
        basicInteractions.waitingTimeOUT(2000);
    }

    public void clickPayrollInformationTab() {
        basicInteractions.waitingTimeOUT(1000);
        payrollInformationTab.shouldBeCurrentlyVisible();
        basicInteractions.clickIfGivenElementDisplayed(payrollInformationTab);
    }
}
