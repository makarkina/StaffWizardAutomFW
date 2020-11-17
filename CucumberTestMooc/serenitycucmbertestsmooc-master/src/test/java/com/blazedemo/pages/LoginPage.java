package com.blazedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://vgroll.com:8080/vroll/")
public class LoginPage extends PageObject {
    @FindBy(id="username")
    WebElementFacade userName;
    @FindBy(id="password")
    WebElementFacade password;

    public void typeUserName(String text){
        userName.sendKeys(text);
    }
    public void typePassword(String text){
        password.sendKeys(text);
    }
}
