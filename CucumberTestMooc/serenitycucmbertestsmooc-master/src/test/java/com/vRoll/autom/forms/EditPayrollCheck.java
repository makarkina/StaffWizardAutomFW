package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class EditPayrollCheck extends PageObject {

    @FindBy(css =
            "//div[@class='form-group state-success']//input[@class='form-control']")
    WebElementFacade employeeBox;

    @FindBy(xpath =
            "//div[@class='d-flex mb-2 mt-2']//div[@class='btn btn-success btn-sm save-btn']")
    WebElementFacade saveButton;

    @FindBy(css =
            "input[name='federalTax']")
    WebElementFacade federalTaxBox;

    @FindBy(css =
            "input[name='eeOasdiTax']")
    WebElementFacade eeOASDITaxBox;

    @FindBy(css =
            "input[name='eeMedicareTax']")
    WebElementFacade eeMedicareTaxBox;

    @FindBy(css =
            "input[name='fuiTax']")
    WebElementFacade fuiTaxBox;

    @FindBy(css = "#check-details-tab")
    WebElementFacade checkDetailsTab;

    @FindBy(css = "#check-states-tab")
    WebElementFacade checkStatesTab;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr//td[1]"))
    List<WebElement> EDList;

    @FindBy(xpath =
            "//div[@data-newformname='forms/payrollcheckdetail/new']")
    WebElementFacade addButton;

    @FindBy(xpath =
            "//div[@data-editformname='forms/payrollcheckdetail/edit']")
    WebElementFacade editButton;

    @FindBy(xpath =
            "//div[@data-editformname='forms/payrollcheckstate/edit']")
    WebElementFacade editStateButton;

    BasicInteractions basicInteractions;

    public void clickCheckDetailsTab() {
        basicInteractions.waitingTimeOUT(2000);
        basicInteractions.ifElementEnabled(checkDetailsTab, basicInteractions);
    }

    public void clickEditButton() {
        basicInteractions.ifElementEnabled(editButton, basicInteractions);
    }

    public void clickEditStateButton() {
        basicInteractions.ifElementEnabled(editStateButton, basicInteractions);
    }

    public void opensNewCheckDetails() {
        //basicInteractions.waitingTimeOUT(500);
        basicInteractions.ifElementEnabled(addButton, basicInteractions);
    }

    public void clickCheckStatesTab() {
        basicInteractions.waitingTimeOUT(1500);
        basicInteractions.ifElementEnabled(checkStatesTab, basicInteractions);
    }

    public void selectED(String givenED) {
        basicInteractions.clickIfElementWithGivenParamDisplayed(givenED
                , EDList, basicInteractions);
    }

    public void verifyFedTaxes(String federal, String eeOASDI
                        , String eeMedicare, String fui) {
        basicInteractions.waitingTimeOUT(1000);
        basicInteractions.assertContainsIfElementEnabled(federal, federalTaxBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(eeOASDI, eeOASDITaxBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(eeMedicare, eeMedicareTaxBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(fui, fuiTaxBox, basicInteractions);
    }

    public void clickSaveButton() {
        basicInteractions.waitingTimeOUT(500);
        basicInteractions.ifElementEnabled(saveButton, basicInteractions);
        basicInteractions.waitingTimeOUT(2000);
    }
}
