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
            "//div[@id='pagination-PayrollCheck']//span[@class='total-pages']")
    WebElementFacade pagesNumber;

    @FindBy(xpath =
            "//div[@class='btn btn-default btn-sm fragment-pagination-next mr-2']")
    WebElementFacade nextButton;

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
            "//div[@class='dropdown-menu dropdown-menu-right show']//div[contains(.,'Calculate Check')]")
    WebElementFacade calculateCheck;

    @FindBy(css = ".dropdown-menu-right.show > a:nth-child(1)")
    WebElementFacade payrollCheckDetails;

    BasicInteractions basicInteractions;

    public String chosenCheckDate;
    public String chosenEmployee;
    public String chosenGrossWages;
    public String chosenNetWages;
    public int employeeNumber = 0;

    public void addNewCheckForEmployee() {
        basicInteractions.waitingTimeOUT(1000);
        basicInteractions.ifElementEnabled(addCheckButton, basicInteractions);
     }

    public void selectGearButtonForGivenEmployee(String givenEmployee) {
        basicInteractions.waitingTimeOUT(3000);
        basicInteractions.clickDifElementIfElemWithParamDisplayed(givenEmployee, employeesList
                                    , basicInteractions, gearButtonList);
    }

    public void clickEditButtonForGivenEmployee(String givenEmployee) {
        basicInteractions.waitingTimeOUT(1500);
        basicInteractions.clickDifElementIfElemWithParamDisplayed(givenEmployee, employeesList
                                    , basicInteractions, editButtonList);
    }

    public void calculateCheckForEmployee() throws InterruptedException {
        basicInteractions.ifElementEnabled(calculateCheck, basicInteractions);
        basicInteractions.waitingTimeOUT(3000);
    }

     public void verifyDateForAllChecks() {
         basicInteractions.waitingTimeOUT(3000);
         if (dateForCheckList.get(dateForCheckList.size() - 1).isDisplayed()) {
             for (int i = 0; i < dateForCheckList.size(); i++) {
                 Assert.assertEquals(dateForCheckList.get(i).getText().substring(0, 10)
                         , PayrollPage.lastPayCheckDate);
             }
         } else {
             System.out.println("Check Date is not displayed ");
         }
     }

     public void verifyInfoForSingleCheck(String givenEmployee
             , String grossWages, String netWages) {
         basicInteractions.assertIfElementDisplayed(grossWages, employeeGrossWagesList, chosenGrossWages);
         basicInteractions.assertIfElementDisplayed(netWages, employeeGrossWagesList, chosenNetWages);
    }

    /*public void verifyNumberOfChecks(String allEmployees) {
        basicInteractions.getNumberOfAllElements(allEmployees, employeesList);
    }*/

    public void verifyNumberOfChecks(String allEmployees) {
        basicInteractions.waitingTimeOUT(500);
        employeesList.get(editButtonList.size()-1).isDisplayed();
        String numberOfPages = pagesNumber.getText();
        int pages = Integer.parseInt(numberOfPages);
        int count = employeesList.size();
        for (int i = 0; i < pages; i++) {
            if (nextButton.isCurrentlyVisible()) {
                nextButton.click();
                count = count + employeesList.size();
            } else {
                System.out.println("NextButton is not clickable");
            }
        }
        basicInteractions.assertNumberOfElements(count, allEmployees, employeesList);
        System.out.println("Number of checks: " + count);
    }

    public void openPayrollCheckDetailsForGivenEmployee(String givenEmployee){
        basicInteractions.clickElemIfDifElemContainsParam(givenEmployee, employeesList, arrowButtonList);
        basicInteractions.clickIfGivenElementDisplayed(payrollCheckDetails);
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

    public void verifyDateOnSelectedCheck(String givenCheckDate) {
        Assert.assertEquals(dateForCheckList.get(0).getText().substring(0, 10)
                , givenCheckDate);
    }
}