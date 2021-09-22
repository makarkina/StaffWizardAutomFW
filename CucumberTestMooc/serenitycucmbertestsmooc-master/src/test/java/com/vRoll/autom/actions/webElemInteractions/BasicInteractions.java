package com.vRoll.autom.actions.webElemInteractions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicInteractions {

    public static boolean clickIfButtonEnabled(WebElementFacade webElement, String s) {
        if (webElement.isCurrentlyVisible()) {
            webElement.click();
            return true;
        } else {
            System.out.println(s);
            return false;
        }
    }

    /*public static boolean clickIfListOfElementsDisplayed(int i, List<WebElement> ListOfElements
                                                , int i2, String s) {
        if (ListOfElements.get(i2).isDisplayed()) {
            ListOfElements.get(i).click();
            return true;
        } else {
            System.out.println(s);
            return false;
        }
    }*/

    public static void clickIfElementContainsParameter(String stringValue
                                        , List<WebElement> listOfWebElements) {
        for (int i = 0; i < listOfWebElements.size(); i++) {
            if (listOfWebElements.get(i).getText().contains(stringValue)) {
                listOfWebElements.get(i).click();
                break;
            } else {
                continue;
            }
        }
    }

    public static boolean clickIfDropDownItemEnabled(String stringValue
            , List<WebElement> listOfWebElements, BasicInteractions basicInteractions) {
        if (listOfWebElements.get(listOfWebElements.size()-1).isEnabled()) {
            basicInteractions.clickIfElementContainsParameter(stringValue, listOfWebElements);
            return true;
        } else {
            System.out.println("Item of dropdown menu is not enabled");
            return false;
        }
    }

    public static boolean clickIfGivenElementOfListDisplayed(WebElementFacade webElement, String s) {
        if (webElement.isDisplayed()) {
            webElement.click();
            return true;
        } else {
            System.out.println(s);
            return false;
        }
    }

    public static boolean ifElementDisplayed(WebElementFacade webElement, BasicInteractions basicInteractions) {
        if (webElement.isDisplayed()) {
            basicInteractions.clickIfButtonEnabled(webElement, webElement + " is not clickable");
            return true;
        } else {
            return false;
        }
    }

    public static boolean sendKeyIfElementEnabled(String stringValue, WebElementFacade webElement, String s) {
        if (webElement.isEnabled()) {
            webElement.clear();
            webElement.sendKeys(stringValue);
            webElement.shouldBeVisible();
            System.out.println(webElement.getText());
            return true;
        } else {
            System.out.println(webElement + " is not enabled");
            return false;
        }
    }

    public static boolean sendKeyIfElementDisplayed(String stringValue, WebElementFacade webElement, BasicInteractions basicInteractions) {
        if (webElement.isDisplayed()){
            basicInteractions.sendKeyIfElementEnabled(stringValue, webElement, " is not enabled");
            return true;
        } else {
            System.out.println(webElement + " is not displayed");
            return false;
        }
    }

    public static boolean clickDropDownItemIfBoxEnabled(String stringValue, WebElementFacade webElement
            , BasicInteractions basicInteractions, List<WebElement> listOfWebElements) {
        if (webElement.isEnabled()) {
            basicInteractions.clickIfElementContainsParameter(stringValue, listOfWebElements);
            return true;
        } else {
            System.out.println(webElement + " is not enabled");
            return false;
        }
    }

    public static void waitingTimeOUT(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
