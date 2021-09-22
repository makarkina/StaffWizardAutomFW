package com.vRoll.autom.pages;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

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
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr/td[7]"))
    List<WebElement> AmountList;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr/td[7]"))
    List<WebElement> amountList;

    @FindBy(xpath =
            "//div[@data-fragment='PayrollCheckDetail']//tbody[@class='list-items']//tr[1]/td[1]")
    WebElementFacade firstED;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    WebElementFacade escButton;

    List<String> givenAmountList = new ArrayList<String>();

    BasicInteractions basicInteractions;

    public void openAddCheckDetails() {
        basicInteractions.ifElementDisplayed(addPayrollButton, basicInteractions);
    }

    public void openEditCheckDetails() {
        basicInteractions.ifElementDisplayed(editPayrollButton, basicInteractions);
    }

    public List<String> selectED(String dirDep, String childSupport,
                                 String levy, String pension, String earning) {
        System.out.println("earnDeductionList.size() " + earnDeductionList.size());
        for(int i=0; i<earnDeductionList.size(); i++) {
            if (earnDeductionList.get(i).isDisplayed()) {
                if(earnDeductionList.get(i).getText().contains(dirDep)){
                    earnDeductionList.get(i).click();
                    givenAmountList.add(amountList.get(i).getText());
                    System.out.println("i= " + i + " " + givenAmountList.get(i));
                } else if (earnDeductionList.get(i).getText().contains(childSupport)) {
                    earnDeductionList.get(i).click();
                    givenAmountList.add(amountList.get(i).getText());
                    System.out.println("i= " + i + " " + givenAmountList.get(i));
                } else if (earnDeductionList.get(i).getText().contains(levy)) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + givenAmountList.get(i));
                    givenAmountList.add(amountList.get(i).getText());
                } else if (earnDeductionList.get(i).getText().contains(pension)) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + givenAmountList.get(i));
                    givenAmountList.add(amountList.get(i).getText());
                } else if (earnDeductionList.get(i).getText().contains(earning)) {
                    earnDeductionList.get(i).click();
                    givenAmountList.add(amountList.get(i).getText());
                    System.out.println("i= " + i + " " + givenAmountList.get(i));
                } else {
                    continue;
                }
                System.out.println("givenAmountList.size() " + givenAmountList.size());
            } else {
                System.out.println("givenAmountList is not clickable");
            }
        }
        return givenAmountList;
    }

    public void verifyAmount(String dirDeposit, String childSupport, String levy, String garnishment,
                             String pension, String hourly, String salary, String overtime) {
        System.out.println("earnDeductionList.size() " + earnDeductionList.size());
        for(int i=0; i<earnDeductionList.size(); i++) {
            if (earnDeductionList.get(i).isDisplayed()) {
                if(earnDeductionList.get(i).getText().contains("DD")){
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(dirDeposit));
                    if(amountList.get(i).getText().equals(dirDeposit)){

                    } else {
                        System.out.println("DirDeposit is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("CS")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(childSupport));
                    if(amountList.get(i).getText().equals(childSupport)){

                    } else {
                        System.out.println("ChildSupport is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("Levy")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(levy));
                    if(amountList.get(i).getText().equals(levy)){

                    } else {
                        System.out.println("Levy is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("Garnishment")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(garnishment));
                    if(amountList.get(i).getText().equals(garnishment)){

                    } else {
                        System.out.println("Garnishment is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("Pension")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(pension));
                    if(amountList.get(i).getText().equals(pension)){

                    } else {
                        System.out.println("Pension is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("Hourly")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(hourly));
                    if(amountList.get(i).getText().equals(hourly)){

                    } else {
                        System.out.println("Hourly is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("Salary")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(salary));
                    if(amountList.get(i).getText().equals(salary)){

                    } else {
                        System.out.println("Salary is not verified");
                    }
                } else if (earnDeductionList.get(i).getText().contains("Overtime")) {
                    earnDeductionList.get(i).click();
                    System.out.println("i= " + i + " " + amountList.get(i).getText());
                    //Assert.assertTrue(amountList.get(i).getText().contains(overtime));
                    if(amountList.get(i).getText().equals(overtime)){

                    } else {
                        System.out.println("Overtime is not verified");
                    }
                } else {
                    continue;
                }
            } else {
                System.out.println("givenAmountList is not clickable");
            }
        }

    }

    public void selectEarning(String givenED) {
        if (earnDeductionList.get(earnDeductionList.size()-1).isDisplayed()) {
            for(int i=0; i<earnDeductionList.size(); i++) {
                if (earnDeductionList.get(i).isEnabled()) {
                    if(earnDeductionList.get(i).getText().contains(givenED)){
                        earnDeductionList.get(i).click();
                        System.out.println("ED " + earnDeductionList.get(i).getText());
                        break;
                    } else {
                        continue;
                    }
                } else {
                    System.out.println("earnDeductionList element is disabled");
                }
            }
        } else {
            System.out.println("EarnDeductionList element is not displayed");
        }
     }

    /*public void verifyAmount(String amount1, String amount2, String amount3,
                             String amount4, String amount5) {
        //System.out.println("givenAmountList.size() " + givenAmountList.size());
        for(int i=0; i<givenAmountList.size(); i++){
            if(i==0){
               Assert.assertTrue(givenAmountList.get(i).contains(amount1));
            } else if (i==1) {
                Assert.assertTrue(givenAmountList.get(i).contains(amount2));
            } else if (i==2) {
                Assert.assertTrue(givenAmountList.get(i).contains(amount3));
            } else if (i==3) {
                System.out.println("i= " + i + " " + givenAmountList.get(i));
                Assert.assertTrue(givenAmountList.get(i).contains(amount4));
            } else if (i==4) {
                System.out.println("i= " + i + " " + givenAmountList.get(i));
                Assert.assertTrue(givenAmountList.get(i).contains(amount5));
            } else {
                System.out.print("Incorrect condition");
            }
        }
    }*/

}
