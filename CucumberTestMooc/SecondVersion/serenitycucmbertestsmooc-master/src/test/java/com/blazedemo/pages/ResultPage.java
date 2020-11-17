package com.blazedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {
    @FindBy(xpath="//table/thead/tr/th[4]")
    WebElementFacade resultForDepCity;

    public boolean isResultDisplayed(){
        resultForDepCity.waitUntilVisible();
        return resultForDepCity.isDisplayed();
    }

    public String choosenDepCity () {
        return resultForDepCity.getText();
    }
}
