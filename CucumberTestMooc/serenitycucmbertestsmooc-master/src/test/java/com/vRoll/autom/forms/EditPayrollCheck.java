package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditPayrollCheck extends PageObject {

    @FindBy(css =
            "input[name='federalTax']")
    WebElementFacade federalTax;

    @FindBy(css =
            "input[name='eeOasdiTax']")
    WebElementFacade eeOASDITax;

    @FindBy(css =
            "input[name='eeMedicareTax']")
    WebElementFacade eeMedicareTax;

    @FindBy(css =
            "input[name='fuiTax']")
    WebElementFacade fuiTax;

    @FindBy(css = "#check-details-tab")
    WebElementFacade checkDetailsTab;

    @FindBy(css = "#check-states-tab")
    WebElementFacade checkStatesTab;

    @FindAll(@FindBy(xpath =
            "//div/div/div[4]/div[2]/div/div[2]/table/tbody/tr/td[1]"))
    List<WebElement> EDList;

    @FindBy(xpath =
            "//div[@data-newformname='forms/payrollcheckdetail/new']")
    WebElementFacade addButton;

    @FindBy(xpath =
            "//div[@data-editformname='forms/payrollcheckdetail/edit']")
    WebElementFacade editButton;

    @FindBy(xpath =
            "//div[@data-editformname='forms/payrollcheckstate/edit']")
    WebElementFacade editStateButton;

    BasicInteractions basicInteractions;

    public void clickCheckDetailsTab() {
        basicInteractions.ifElementDisplayed(checkDetailsTab, basicInteractions);
    }

    public void clickEditButton() {
        basicInteractions.ifElementDisplayed(editButton, basicInteractions);
    }

    public void clickEditStateButton() {
        basicInteractions.ifElementDisplayed(editStateButton, basicInteractions);
    }

    public void opensNewCheckDetails() {
        basicInteractions.ifElementDisplayed(addButton, basicInteractions);
    }

    public void clickCheckStatesTab() {
        basicInteractions.waitingTimeOUT(1500);
        basicInteractions.ifElementDisplayed(checkStatesTab, basicInteractions);
    }

    public void selectED(String givenED) {
        for(int i=0; i<EDList.size(); i++) {
                if(EDList.get(i).getText().contains(givenED)){
                    EDList.get(i).click();
                    System.out.println("ED " + EDList.get(i).getText());
                    break;
                } else {
                    continue;
                }
        }
    }

    public void verifyFedTaxes(String fedTax, String eeOASDI
                        , String eeMedicare, String fui) {
        federalTax.shouldBeCurrentlyVisible();
        if (federalTax.isCurrentlyVisible()){
            assertThat(federalTax.getAttribute("value"), equalTo(fedTax));
            System.out.println("federalTax " + federalTax.getAttribute("value"));
        } else {
            System.out.println("fedTax is not verified");
        }
        if (eeOASDITax.isCurrentlyVisible()){
            assertThat(eeOASDITax.getAttribute("value"), equalTo(eeOASDI));
            System.out.println("eeOASDITax " + eeOASDITax.getAttribute("value"));
        } else {
            System.out.println("eeOASDITax is not verified");
        }
        if (eeMedicareTax.isCurrentlyVisible()){
            assertThat(eeMedicareTax.getAttribute("value"), equalTo(eeMedicare));
            System.out.println("eeMedicareTax " + eeMedicareTax.getAttribute("value"));
        } else {
            System.out.println("eeMedicareTax is not verified");
        }
        if (fuiTax.isCurrentlyVisible()){
            assertThat(fuiTax.getAttribute("value"), equalTo(fui));
            System.out.println("fuiTax " + fuiTax.getAttribute("value"));
        } else {
            System.out.println("fuiTax is not verified");
        }
    }
}
