package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;

public class EditPayrollCheckState extends PageObject {

    @FindBy(css = "input[name='stateTax']")
    WebElementFacade stateTaxBox;

    @FindBy(css = "input[name='eeSdiTax']")
    WebElementFacade eeSdiTaxBox;

    @FindBy(css = "input[name='stateTax']")
    WebElementFacade fliTaxBox;

    BasicInteractions basicInteractions;

    public void verifyStateTaxes(String stateTax, String eeSdiTax) {
        basicInteractions.waitingTimeOUT(1500);
        /*basicInteractions.assertContainsIfElementEnabled(stateTax, stateTaxBox, basicInteractions);
        basicInteractions.assertContainsIfElementEnabled(eeSdiTax, eeSdiTaxBox, basicInteractions);*/
    }
}
