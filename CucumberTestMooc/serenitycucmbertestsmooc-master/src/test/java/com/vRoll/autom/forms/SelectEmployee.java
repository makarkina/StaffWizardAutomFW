package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectEmployee extends PageObject {

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='employee_list']//tbody[@class='list-items']//tr/td[3]"))
    List<WebElement> employeesList;

    @FindBy(xpath =
            "//div[@data-fragment='employee_list']//tbody[@class='list-items']//tr[10]/td[3]")
    WebElementFacade firstEmployee;

    BasicInteractions basicInteractions;



    public void selectEmployee(String chosenEmployee) {
        basicInteractions.clickIfElementWithGivenParamDisplayed(chosenEmployee, employeesList, basicInteractions);
    }
}

