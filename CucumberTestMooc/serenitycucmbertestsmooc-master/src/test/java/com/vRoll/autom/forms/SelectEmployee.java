package com.vRoll.autom.forms;

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

    public void selectEmployee(String chosenEmployee){
        firstEmployee.shouldBeVisible();
        for(int i=0; i<employeesList.size(); i++) {
            if(employeesList.get(i).getText().contains(chosenEmployee)){
                employeesList.get(i).click();
                break;
            } else {
                continue;
            }
        }
    }
}
