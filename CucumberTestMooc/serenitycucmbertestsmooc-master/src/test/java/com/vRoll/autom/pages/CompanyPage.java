package com.vRoll.autom.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.MoveMouse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;


public class CompanyPage extends PageObject {

    @FindBy(xpath="//i[@class='fa fa-plus fs20']")
    WebElementFacade addCompanySign;

    @FindBy(xpath="//a[@id='dropdownMenuLink']")
    WebElementFacade chooseOptionsSign;

    @FindBy(xpath="//a[@data-title='Employees']")
    WebElementFacade employeesOption;

    @FindBy(xpath="//a[@data-title='Payroll checks']")
    WebElementFacade payrollCheckOption;

    @FindBy(xpath="//tr[@data-itemdescription='GuardHub']")
    WebElementFacade companyLine;

    @FindAll(@FindBy(xpath = "//table[@class='table table-hover list-table']//tbody[@class='list-items']//tr"))
    List<WebElement> allElements;

    public void addNewCompany(){
        addCompanySign.click();
    }

    public void clickOnChoosingOptions(){
        chooseOptionsSign.click();
    }

    public static Target COMPANY_LINE = Target.the("Company row")
            .located(By.xpath("//tr[@data-itemdescription='GuardHub']"));

    public void selectCompany(Actor actor) throws InterruptedException{
        companyLine.waitUntilVisible();
        actor.attemptsTo(DoubleClick.on(COMPANY_LINE));// вуаляяя
        /*actor.attemptsTo(
                MoveMouse.to(SELECT_COMPANY)
                .andThen(actions -> actions.doubleClick()));*/
    }

    public void selectEmployeesOption() {
        employeesOption.click();
    }

    public void selectCompanyByName(String companyName) {
        System.out.println("allElements "+ allElements.size());
        for (int i = 0; i < allElements.size(); i++) {
            String targetName = allElements.get(i).getText();
            if (targetName.equals(companyName)){
                allElements.get(i).click();
                break;
            } else {
                continue;
            }
        }

    }
}
