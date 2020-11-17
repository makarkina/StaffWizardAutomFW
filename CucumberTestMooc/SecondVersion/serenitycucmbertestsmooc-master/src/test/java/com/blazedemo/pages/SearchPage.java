package com.blazedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

//@DefaultUrl("http://blazedemo.com")
public class SearchPage extends PageObject {
    @FindBy(name="fromPort")
    WebElementFacade chooseDepartCity;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElementFacade searchChooseFlightButton;

    public void chooseDeparture(String text){
        chooseDepartCity.selectByValue(text);
    }

    public void clickChooseFlightButton() {
        searchChooseFlightButton.click();
    }
}
