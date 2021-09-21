package com.vRoll.autom.forms;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CompanyScreen extends PageObject {

    @FindBy(xpath="//input[@name='name']")
    WebElementFacade name;

    public String getName(){
        return name.getText();
    }
}
