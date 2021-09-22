package com.vRoll.autom.forms;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditCompanyDetails extends PageObject {

    @FindBy(xpath =
            "//button[@data-formname='forms/enum/payfreq']")
    WebElementFacade payFrequencyDropDownButton;

    @FindAll(@FindBy(xpath =
            "//div[@data-fragment='payfreq']//tbody[@class='list-items']//tr"))
    List<WebElement> payFrequencyDropDownList;

    @FindBy(xpath =
            "//div[@class='btn btn-success btn-sm'][1]")
    WebElementFacade saveButton;

    BasicInteractions basicInteractions;

    public void clickPayFrequencyDropDownButton() {
        basicInteractions.ifElementDisplayed(payFrequencyDropDownButton, basicInteractions);
    }

    public void clickSaveButton() {
        basicInteractions.ifElementDisplayed(saveButton, basicInteractions);
    }

    public void selectPayFrequency(String payFrequency) {
        for(int i=0; i < payFrequencyDropDownList.size(); i++) {
            if (payFrequencyDropDownList.get(i).getText().equals(payFrequency)) {
                payFrequencyDropDownList.get(i).click();
                break;
            } else {
                continue;
            }
        }
    }

}
