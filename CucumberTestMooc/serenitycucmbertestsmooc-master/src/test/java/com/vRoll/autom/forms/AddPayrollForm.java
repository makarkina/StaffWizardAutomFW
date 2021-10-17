package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import com.vRoll.autom.pages.PayrollPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;


public class AddPayrollForm extends PageObject {

    @FindBy(xpath =
            "//div[@meta-widget-name='periodBeginDate']//input[@type='text']")
    WebElementFacade beginDateField;

    @FindBy(xpath =
            "//div[@meta-widget-name='periodEndDate']//input[@type='text']")
    WebElementFacade endDateField;

    @FindBy(xpath ="//div[@meta-widget-name='checkDate']//input[@type='text']")
    WebElementFacade checkDateField;

    @FindBy(xpath =
            "//div[@class='d-flex mb-2 mt-2']//div[@class='d-flex flex-column justify-content-around pl-2'][1]")
    WebElementFacade savePayrollButton;

    BasicInteractions basicInteractions;
    PayrollPage payrollPage;

    public static String trPeriodBeginDate;
    public static String trPeriodEndDate;

    public void enterDate (String beginDateAsText,
                           String endDateAsText, String checkDateAsText){
        beginDateField.sendKeys(beginDateAsText);
        endDateField.sendKeys(endDateAsText);
        checkDateField.sendKeys(checkDateAsText);
    }

    public void enterDatesToNewPayrollForm() {
        String trPeriodBeginDate = delNoDig(payrollPage.estNewPeriodBeginDate);
        String trPeriodEndDate = delNoDig(payrollPage.estNewPeriodEndDate);

        beginDateField.sendKeys(trPeriodBeginDate);
        endDateField.sendKeys(trPeriodEndDate);
        checkDateField.sendKeys(trPeriodEndDate);
    }

    public static String delNoDig (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character .isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public void saveNewPayroll(){
        //assertThat(savePayrollButton.isEnabled(), equalTo(true));
        basicInteractions.ifElementEnabled(savePayrollButton, basicInteractions);
        basicInteractions.waitingTimeOUT(1000);
    }
}
