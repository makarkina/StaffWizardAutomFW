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
            "//div[@class='d-flex mb-2 mt-2']//div[@class='btn btn-success btn-sm save-btn']")
    WebElementFacade saveCheckButton;

    @FindBy(xpath ="//div[@class='card-header bg-lightblue  text-white']")
    WebElementFacade formTitle;

    @FindBy(xpath ="//button[@data-formname='forms/employee/select']")
    WebElementFacade employeeSelectButton;

    BasicInteractions basicInteractions;

    public void openEmployeeSelect(){
        basicInteractions.ifElementEnabled(employeeSelectButton, basicInteractions);
    }

    public void saveNewCheck(){
        basicInteractions.ifElementEnabled(saveCheckButton, basicInteractions);
        basicInteractions.waitingTimeOUT(2000);
    }
}
