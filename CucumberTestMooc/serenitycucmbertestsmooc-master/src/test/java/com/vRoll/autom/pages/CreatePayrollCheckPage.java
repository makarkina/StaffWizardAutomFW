package com.vRoll.autom.pages;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class CreatePayrollCheckPage extends PageObject {

    @FindBy(xpath=
            "//div[@class='card-footer']//div[contains(.,' Create Checks With Earnings/Deductions ')]")
    WebElementFacade createCheckWithED;

    BasicInteractions basicInteractions;

    public void clickCreateCheckWithED() {
        basicInteractions.ifElementDisplayed(createCheckWithED, basicInteractions);
        basicInteractions.waitingTimeOUT(3000);
    }
}
