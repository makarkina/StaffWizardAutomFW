package com.vRoll.autom.pages;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject{

        @FindBy(xpath="//li[@class='nav-item has-treeview']")
        WebElementFacade companiesMode;

        @FindBy(xpath="//a[@data-href='forms/company/edit']")
        WebElementFacade editCompanyDetails;

        @FindBy(xpath="//a[@data-href='forms/employee/list']")
        WebElementFacade employeesMode;

        @FindBy(css="li[class='nav-item']>a[data-href='forms/payroll/list']")
        WebElementFacade payrollsMode;

        @FindBy(xpath="//div[@class='col-4'][1]/ul//a[@data-href='forms/company/list']")
        WebElementFacade companiesOption;

        BasicInteractions basicInteractions;

    public void selectCompaniesMode(){
        basicInteractions.ifElementEnabled(companiesMode, basicInteractions);
    }

    public void openEditCompanyDetails(){
        basicInteractions.ifElementEnabled(editCompanyDetails, basicInteractions);
    }

    public void selectEmployeeMode(){
        basicInteractions.ifElementEnabled(employeesMode, basicInteractions);
    }

    public void selectPayrollsMode(){
        basicInteractions.ifElementEnabled(payrollsMode, basicInteractions);
    }

    public void selectCompaniesOption() {
        companiesOption.click();
    }
}
