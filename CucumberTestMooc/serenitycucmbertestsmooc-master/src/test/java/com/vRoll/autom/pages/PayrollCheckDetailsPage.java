package com.vRoll.autom.pages;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;


public class PayrollCheckDetailsPage extends PageObject {

    @FindBy(xpath=
            "//div[@data-fragment='PayrollCheckDetail']//div[@class='btn btn-success btn-sm']")
    WebElementFacade addPayrollButton;

    @FindBy(xpath = "//div[@data-editformname='forms/payrollcheckdetail/edit']")
    WebElementFacade editPayrollButton;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr"))
    List<WebElement> earnDeductionList;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr/td[1]"))
    List<WebElement> edTypeList;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr/td[7]"))
    List<WebElement> amountList;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    WebElementFacade escButton;

    BasicInteractions basicInteractions;

    public static int count = 0;

    public void openAddCheckDetails() {
        //basicInteractions.ifElementEnabled(addPayrollButton, basicInteractions);
    }

    public void openEditCheckDetails() {
        basicInteractions.waitingTimeOUT(500);
        //basicInteractions.ifElementEnabled(editPayrollButton, basicInteractions);
    }

    public void verifyNumberOfExistED(String dirDeposit, String childSupport, String levy, String garnishment,
                                       String pension, String hourly, String salary, String overtime) {
        ArrayList<String> listOfParameters = new ArrayList<String>();
        listOfParameters.add(dirDeposit);
        listOfParameters.add(childSupport);
        listOfParameters.add(levy);
        listOfParameters.add(garnishment);
        listOfParameters.add(pension);
        listOfParameters.add(hourly);
        listOfParameters.add(salary);
        listOfParameters.add(overtime);

        basicInteractions.waitingTimeOUT(2000);
        for (int i=0; i < listOfParameters.size(); i++) {
            if (!listOfParameters.get(i).equals("")) {
                count++;
            }
        }
        System.out.println("count" + count);
        if(count==earnDeductionList.size()){
            Assert.assertEquals(count,earnDeductionList.size());
        } else {
            System.out.println("Verification failed: number of EDs in check doesn't match expected number");
            Assert.assertEquals(earnDeductionList.size(),-1);
        }
    }


    public void verifyAmount(String dirDeposit, String childSupport, String levy, String garnishment,
                             String pension, String hourly, String salary, String overtime) {
        for (int i = 0; i < amountList.size(); i++) {
            basicInteractions.assertEqualsIfListElemEnabled(dirDeposit, i, amountList, edTypeList, "DD");
            basicInteractions.assertEqualsIfListElemEnabled(childSupport, i, amountList, edTypeList, "CS");
            basicInteractions.assertEqualsIfListElemEnabled(levy, i, amountList, edTypeList, "LEVY");
            basicInteractions.assertEqualsIfListElemEnabled(garnishment, i, amountList, edTypeList, "GARNISH");
            basicInteractions.assertEqualsIfListElemEnabled(pension, i, amountList,  edTypeList, "Pension");
            basicInteractions.assertEqualsIfListElemEnabled(hourly, i, amountList,  edTypeList, "HOURS");
            basicInteractions.assertEqualsIfListElemEnabled(salary, i, amountList, edTypeList, "Salary");
            basicInteractions.assertEqualsIfListElemEnabled(overtime, i, amountList, edTypeList, "OT");
        }
    }

    public void selectEarning(String givenED) {
        basicInteractions.clickIfElementWithGivenParamDisplayed(givenED, earnDeductionList, basicInteractions);
    }
}
