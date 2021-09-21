package com.vRoll.autom.pages;


import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class PayrollChecksPage extends PageObject {

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr/td[6]//div[@class='btn-group'][2]"))
    List<WebElement> gearButtonList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr/td[6]//div[@class='btn-group'][1]"))
    List<WebElement> arrowButtonList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr/td[6]//i[@class='fa fa-edit']"))
    List<WebElement> editButtonList;

    @FindBy(xpath =
            "//span[@class='total-pages']")
    WebElementFacade pagesNumber;

    @FindBy(xpath =
            "//div[@class='btn btn-default btn-sm fragment-pagination-next mr-2']")
    WebElementFacade nextButton;

    @FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr[1]/td[6]//div[@class='btn-group'][1]")
    WebElementFacade lastArrowButton;

    /*@FindBy(xpath =
            "//section[@id='main-container']//div[@data-depends-on='payroll']//div[@class='d-flex pt-2 pb-2']//div[@class='btn btn-success btn-sm']")
    WebElementFacade addCheckButton;*/

    @FindBy(xpath =
            "//div[@class='d-flex pt-2 pb-2']//div[@class='d-flex flex-column justify-content-around pl-2']//i[@class='fa fa-plus']")
    WebElementFacade addCheckButton;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr/td[3]"))
    List<WebElement> employeesList;

    @FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr[1]/td[3]")
    WebElementFacade lastEmployeeName;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']//tr/td[4]"))
    List<WebElement> employeeGrossWagesList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']//tr/td[5]"))
    List<WebElement> employeeNetWagesList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payrollcheck/list']//tbody[@class='list-items']/tr/td[1]"))
    List<WebElement> dateForCheckList;

    @FindBy(xpath =
            "//div[@class='dropdown-menu dropdown-menu-right show']//div[@class='dropdown-item'][2]")
    WebElementFacade calculateCheck;

    /*@FindBy(xpath =
            "//div[@class='dropdown-menu dropdown-menu-right show']//a[@data-title='Payroll Check Details']")*/
    @FindBy(css = ".dropdown-menu-right.show > a:nth-child(1)")
    WebElementFacade payrollCheckDetails;

    BasicInteractions basicInteractions;

    public String chosenCheckDate;
    public String chosenEmployee;
    public String chosenGrossWages;
    public String chosenNetWages;
    public int employeeNumber = 0;

    public void addNewCheckForEmployee() {
        basicInteractions.ifElementDisplayed(addCheckButton, basicInteractions);
     }

    public void selectGivenEmployee(String givenEmployee) throws InterruptedException {
         if (employeesList.get(employeesList.size()-1).isDisplayed()){
            for (int i = 0; i < employeesList.size(); i++) {
                if (employeesList.get(i).getText().contains(givenEmployee)) {
                    employeesList.get(i).click();
                    chosenEmployee = employeesList.get(i).getText();
                    chosenGrossWages = employeeGrossWagesList.get(i).getText();
                    chosenNetWages = employeeNetWagesList.get(i).getText();
                    System.out.println("chosenEmployee " + chosenEmployee);
                    System.out.println("chosenGrossWages " + chosenGrossWages);
                    System.out.println("chosenNetWages " + chosenNetWages);
                    break;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Employee is not displayed");
        }
    }

    public void selectGearButtonForGivenEmployee(String givenEmployee) {
        if (employeesList.get(employeesList.size()-1).isDisplayed()) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (employeesList.get(i).getText().contains(givenEmployee)) {
                    employeeNumber = i;
                    employeesList.get(i).click();
                    gearButtonList.get(i).click();
                    break;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Employee is not displayed");
        }
    }

    public void clickEditButtonForGivenEmployee(String givenEmployee) {
        if (employeesList.get(employeesList.size()-1).isDisplayed()) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (employeesList.get(i).getText().contains(givenEmployee)) {
                    employeesList.get(i).click();
                    System.out.println("givenEmployee " + givenEmployee);
                    System.out.println(employeeGrossWagesList.get(i).getText());
                    editButtonList.get(i).click();
                    break;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Employee is not displayed");
        }
    }

    public void selectArrowButtonForGivenEmployee(String givenEmployee) {
        if (employeesList.get(employeesList.size()-1).isDisplayed()) {
            for (int i = 0; i < employeesList.size(); i++) {
                if (employeesList.get(i).getText().contains(givenEmployee)) {
                    employeesList.get(i).click();
                    System.out.println(employeesList.get(i).getText());
                    arrowButtonList.get(i).click();

                    break;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Employee is not displayed");
        }
    }

    public void calculateCheckForEmployee() throws InterruptedException {
        basicInteractions.ifElementDisplayed(calculateCheck, basicInteractions);
        basicInteractions.waitingTimeOUT(5000);
    }

     public void verifyDateForAllChecks() {
         if (dateForCheckList.get(dateForCheckList.size() - 1).isDisplayed()) {
             basicInteractions.waitingTimeOUT(3000);
             for (int i = 0; i < dateForCheckList.size(); i++) {
                 Assert.assertEquals(dateForCheckList.get(i).getText().substring(0, 10)
                         , PayrollPage.lastPayCheckDate);
                 System.out.println(dateForCheckList.get(i).getText().substring(0, 10));
             }
         } else {
             System.out.println("Check Date is not displayed ");
         }
     }

     public void verifyInfoForSingleCheck(String givenEmployee
             , String grossWages, String netWages) {
         if (employeeGrossWagesList.get(employeeGrossWagesList.size()-1).isDisplayed()) {
             Assert.assertEquals(chosenGrossWages, grossWages);
             Assert.assertEquals(chosenNetWages, netWages);
         } else {
             System.out.println("EmployeeGrossWages is not displayed");
         }

    }

     public void verifyNumberOfChecks(String allEmployees) {
         if (employeesList.get(employeesList.size()-1).isDisplayed()) {
             Assert.assertEquals(employeesList.size(), Integer.parseInt(allEmployees));
             System.out.println("Number of checks " + employeesList.size());
         } else {
             System.out.println("Employee is not displayed");
         }
      }

}