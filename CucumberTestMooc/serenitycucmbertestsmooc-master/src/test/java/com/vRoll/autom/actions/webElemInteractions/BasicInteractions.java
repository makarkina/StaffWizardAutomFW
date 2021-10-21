package com.vRoll.autom.actions.webElemInteractions;

import com.vRoll.autom.pages.PayrollPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import javax.validation.constraints.AssertTrue;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasicInteractions {

    public static boolean clickIfElementEnabled(WebElementFacade webElement) {
        if (webElement.isEnabled()){
            webElement.click();
            return true;
        } else {
            System.out.println(webElement + " is not available");
            return false;
        }
    }

    public static boolean clickIfButtonEnabled(WebElementFacade webElement) {
        if (webElement.isEnabled()) {
            webElement.click();
            return true;
        } else {
            System.out.println("element is not available");
            return false;
        }
    }

    public static void clickIfElementEqualsToParameter(String stringValue, List<WebElement> listOfWebElements) {
        for (int i = 0; i < listOfWebElements.size(); i++) {
            if (listOfWebElements.get(i).getText().equals(stringValue)) {
                listOfWebElements.get(i).click();
                break;
            } else {
                continue;
            }
        }
    }


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

    public static boolean clickIfElementWithGivenParamDisplayed(String stringValue, List<WebElement> ListOfElements, BasicInteractions basicInteractions) {
        if (ListOfElements.get(ListOfElements.size() - 1).isDisplayed()) {
            basicInteractions.clickIfElementContainsParameter(stringValue, ListOfElements);
            return true;
        } else {
            System.out.println("Last element of the list is not visible");
            return false;
        }
    }

    public static boolean clickIfDropDownItemEnabled(String stringValue
            , List<WebElement> listOfWebElements, BasicInteractions basicInteractions) {
        if (listOfWebElements.get(listOfWebElements.size() - 1).isEnabled()) {
            basicInteractions.clickIfElementContainsParameter(stringValue, listOfWebElements);
            return true;
        } else {
            System.out.println("Item of dropdown menu is not enabled");
            return false;
        }
    }

    public static boolean clickIfGivenElementDisplayed(WebElementFacade webElement) {
        if (webElement.isDisplayed()) {
            webElement.click();
            return true;
        } else {
            System.out.println(webElement + " is not displayed");
            return false;
        }
    }

    public static boolean ifElementEnabled(WebElementFacade webElement, BasicInteractions basicInteractions) {
        if (webElement.isEnabled()) {
            basicInteractions.clickIfButtonEnabled(webElement);
            return true;
        } else {
            System.out.println(webElement + " is not available");
            return false;
        }
    }

    public static boolean assertContainsIfElementEnabled(String parameter, WebElementFacade webElement, BasicInteractions basicInteractions) {
        if (webElement.isEnabled()) {
            basicInteractions.clickIfElementEnabled(webElement);
            if (webElement.getAttribute("value").contains(parameter)) {
                Assert.assertTrue(webElement.getAttribute("value").contains(parameter));
            } else {
                System.out.println("===================");
                System.out.println("Verification FAILED" );
                System.out.println("Expected: " + parameter);
                System.out.println("was: " + webElement.getAttribute("value"));
                Assert.assertTrue(webElement.getAttribute("value").equals("false"));
            }
            return true;
        } else {
            System.out.println(webElement + " is not available");
            return false;
        }
    }

    public static boolean assertEqualsIfElementEnabled(String parameter, WebElementFacade webElement, BasicInteractions basicInteractions) {
        if (webElement.isEnabled()) {
            basicInteractions.clickIfElementEnabled(webElement);
            if (webElement.getAttribute("value").equals(parameter)) {
                Assert.assertTrue(webElement.getAttribute("value").equals(parameter));
            } else {
                System.out.println("===================");
                System.out.println("Verification FAILED" );
                System.out.println("Expected: " + parameter);
                System.out.println("was: " + webElement.getAttribute("value"));
                Assert.assertTrue(webElement.getAttribute("value").equals("false"));
            }
            return true;
        } else {
            System.out.println(webElement + " is not available");
            return false;
        }
    }

    public static boolean assertEqualsIfListElementEnabled(String parameter, List<WebElement> list, int i, BasicInteractions basicInteractions) {
        if (list.get(list.size() - 1).isEnabled()) {
            if (list.get(i).getText().equals(parameter)) {
                //System.out.println("parameter " + parameter);
                //System.out.println("ist.get(i).getText() " + list.get(i).getText());
                Assert.assertEquals(list.get(i).getText(), parameter);
            } else {
                System.out.println("===================");
                System.out.println("Verification FAILED" );
                System.out.println("Expected: " + parameter);
                System.out.println("was: " + list.get(i).getText());
                Assert.assertTrue(list.get(i).getText().equals("false"));
            }
            return true;
        } else {
            System.out.println(list.get(i).getText() + " is not available");
            return false;
        }
    }

    public static boolean assertContainsTextIfElementEnabled(String parameter, WebElementFacade webElement, BasicInteractions basicInteractions) {
        if (webElement.isEnabled()) {
            if (webElement.getText().contains(parameter)) {
                Assert.assertTrue(webElement.getText().contains(parameter));
            } else {
                System.out.println("===================");
                System.out.println("Verification FAILED" );
                System.out.println("Expected: " + parameter);
                System.out.println("was: " + webElement.getText());
                Assert.assertTrue(webElement.getText().equals("false"));
            }
            return true;
        } else {
            System.out.println(webElement.getText() + " is not available");
            return false;
        }
    }

    public static boolean sendKeyIfElementEnabled(String stringValue, WebElementFacade webElement) {
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
        if (webElement.isDisplayed()) {
            basicInteractions.sendKeyIfElementEnabled(stringValue, webElement);
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

    public static void clickElemIfDifElemContainsParam(String stringValue, List<WebElement> list1, List<WebElement> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getText().contains(stringValue)) {
                list2.get(i).click();
                break;
            } else {
                continue;
            }
        }
    }

    public static void clickIfLastLIstElemDisplayed(List<WebElement> list) {
        if (list.get(0).isDisplayed()) {
            list.get(0).click();
        } else {
            System.out.println(list.get(0) + " is not displayed");
        }
    }

    public static void clickDifElementIfElemWithParamDisplayed(String parameter, List<WebElement>
            list1, BasicInteractions basicInteractions, List<WebElement> list2) {
        if (list1.get(list1.size() - 1).isDisplayed()) {
            basicInteractions.clickElemIfDifElemContainsParam(parameter, list1, list2);
        } else {
            System.out.println("Element is not displayed");
        }
    }

    public static void assertEqualsIfListElemEnabled(String parameter, int i
            , List<WebElement> list, List<WebElement> list2, String value){
        if (list.get(i).isEnabled()) {
            if (list2.get(i).getText().contains(value)) {
                if (list.get(i).getText().contains(parameter)) {
                    Assert.assertTrue(list.get(i).getText().contains(parameter));
                } else {
                    System.out.println("===================");
                    System.out.println("Verification FAILED");
                    System.out.println("Expected: " + parameter);
                    System.out.println("was: " + list.get(i).getText());
                    Assert.assertTrue(list.get(i).getText().contains("false"));
                }
            }
        } else {
            System.out.println("Element is not available");
        }
    }

    public static void assertIfListElementEqualsGivenParameter(String value, List<WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i).getText()
                    , value);
            System.out.println("List element is not equal given parameter");
        }
    }

    public static void assertIfListElemEqualsGivParameter(String value, int i
            , List<WebElement> list1, List<WebElement> list2) {
        if (list1.get(i).getText().equals(value)
                & !list1.isEmpty()) {
            System.out.println("Success verification for " + list2.get(i).getText());
        } else {
            System.out.println("Verification failed for " + list2.get(i).getText());
            System.out.println("Expected: " + list1.get(i).getText()
                    + "  was: " + value);
        }
    }

    public static void assertIfElementVisible(String stringValue,
                                              WebElementFacade webElement, String s, String s2) {
        if (webElement.isCurrentlyVisible()) {
            assertThat(webElement.getAttribute("value"), equalTo(stringValue));
            System.out.println(stringValue + " " + webElement.getAttribute("value"));
        } else {
            System.out.println(stringValue + " is not verified");
        }
    }

    public static void assertIfElementDisplayed(String value1, List<WebElement> listOfElements, String value2) {
        if (listOfElements.get(listOfElements.size() - 1).isDisplayed()) {
            if (value2.equals(value1)) {
                Assert.assertEquals(value2, value1);
            } else {
                System.out.println("===================");
                System.out.println("Verification FAILED");
                System.out.println("Expected: " + value1);
                System.out.println("was: " + value2);
            }

            Assert.assertEquals(value2, value1);
        } else {
            System.out.println(value2 + " is not displayed");
        }
    }

    public static void waitingTimeOUT(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void assertNumberOfElements(int value, String parameter, List<WebElement> listOfWebElements) {
        if (listOfWebElements.get(listOfWebElements.size() - 1).isDisplayed()) {
         if (value==Integer.parseInt(parameter)) {
             Assert.assertEquals(value, Integer.parseInt(parameter));
         } else {
             System.out.println("===================");
             System.out.println("Verification FAILED");
             System.out.println("Expected: " + parameter);
             System.out.println("was: " + value);
            }
         } else {
            System.out.println(listOfWebElements + " is not displayed");
         }
    }

    public static void getNumberOfAllElementsOnPage(String stringValue, List<WebElement> listOfWebElements) {
        if (listOfWebElements.get(listOfWebElements.size() - 1).isDisplayed()) {
            if (listOfWebElements.size()==Integer.parseInt(stringValue)) {
                Assert.assertEquals(listOfWebElements.size(), Integer.parseInt(stringValue));
                System.out.println("Number of checks " + listOfWebElements.size());
            }

        } else {
            System.out.println(stringValue + " is not displayed");
        }
    }
}
