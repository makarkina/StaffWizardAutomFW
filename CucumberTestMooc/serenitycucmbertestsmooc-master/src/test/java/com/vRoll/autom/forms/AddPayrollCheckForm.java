package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPayrollCheckForm extends PageObject {
    @FindBy(xpath ="//div[@class='input-group input-group-sm ']/input[@class='form-control']")
    WebElementFacade employeeBox;

    @FindBy(xpath =
            "//div[@data-fragment='PayrollCheck']//div[@class='d-flex mb-2 mt-2']//div[@class='btn btn-success btn-sm']")
    WebElementFacade saveCheckButton;

    @FindBy(xpath ="//div[@class='card-header bg-lightblue  text-white']")
    WebElementFacade formTitle;

    @FindBy(xpath ="//button[@data-formname='forms/employee/select']")
    WebElementFacade employeeSelectButton;

    @FindBy(xpath =
            "//div[@class='card-body ']//div[@meta-widget-name='backupWithholdingOverride']")
    WebElementFacade backWithOverrideBox;

    @FindBy(xpath =
            "//div[@class='card-body d-flex flex-column']//div[@meta-widget-name='notes']")
    WebElementFacade notesBox;

    BasicInteractions basicInteractions;

    public void openEmployeeSelect(){
        basicInteractions.ifElementDisplayed(employeeSelectButton, basicInteractions);
    }

    public void saveNewCheck(){
        basicInteractions.ifElementDisplayed(saveCheckButton, basicInteractions);
        basicInteractions.waitingTimeOUT(2000);
    }
}
