package com.vRoll.autom.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeePage extends PageObject {

    @FindBy(xpath="//a[@id='dropdownMenuLink']")
    WebElementFacade chooseOptionsSign;

    @FindBy(xpath="//a[@data-title='Payroll checks']")
    WebElementFacade payrollCheckOption;

    @FindAll(@FindBy(xpath =
            "//div/div[4]/div[3]/div[2]/table/tbody/tr/td[9]/div[1]/div[1]/i"))
    List<WebElement> employeeList;

    public void clickOnChoosingOptions(){
        chooseOptionsSign.click();
    }

    public void selectPayrollCheck() {
        payrollCheckOption.waitUntilVisible();
        payrollCheckOption.click();
    }

    public void verifyNumberOfEmployees() {
        int count = 0;
        try
        {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //lastArrowButton.shouldBeVisible();
        //Assert.assertEquals(employeesList.size(), Integer.parseInt(allEmployees));
        System.out.println("Number of checks " + employeeList.size());

    }
}
