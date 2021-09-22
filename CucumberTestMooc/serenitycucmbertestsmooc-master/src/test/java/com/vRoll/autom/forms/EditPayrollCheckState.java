package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditPayrollCheckState extends PageObject {

    @FindBy(css = "input[name='stateTax']")
    WebElementFacade stateTaxField;

    @FindBy(css = "input[name='eeSdiTax']")
    WebElementFacade eeSdiTaxField;

    @FindBy(css = "input[name='stateTax']")
    WebElementFacade fliTaxField;

    BasicInteractions basicInteractions;

    public void verifyStateTaxes(String stateTax, String eeSdiTax) {
        basicInteractions.waitingTimeOUT(2000);
        stateTaxField.shouldBeCurrentlyVisible();
        if (stateTaxField.isCurrentlyVisible()){
            assertThat(stateTaxField.getAttribute("value"), equalTo(stateTax));
            System.out.println("stateTax " + stateTaxField.getAttribute("value"));
        } else {
            System.out.println("stateTax is not verified");
        }
        if (eeSdiTaxField.isCurrentlyVisible()){
            assertThat(eeSdiTaxField.getAttribute("value"), equalTo(eeSdiTax));
            System.out.println("eeSdiTax " + eeSdiTaxField.getAttribute("value"));
        } else {
            System.out.println("eeSdiTax is not verified");
        }
    }
}
