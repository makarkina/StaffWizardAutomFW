package com.vRoll.autom.pages;

import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://dev.vgroll.com/")
public class LoginPage extends PageObject {
    @FindBy(id="username")
    WebElementFacade userName;

    @FindBy(id="password")
    WebElementFacade password;

    @FindBy(xpath="//div/form/button")
    WebElementFacade singIn;

    //BasicInteractions basicInteractions;

    @Step
    public void typeUserName(String usName){
        waitForPresenceOf("//div/form/button");
        userName.sendKeys(usName);
    }

    @Step
    public void typePassword(String passWD) { password.sendKeys(passWD);}

    @Step
    public void clickSubmit(){BasicInteractions.clickIfElementEnabled(singIn);
    }
}
