package com.vRoll.autom.pages;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.vRoll.autom.actions.webElemInteractions.BasicInteractions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class PayrollPage extends PageObject {

    @FindBy(xpath =
            "//section[@id='main-container']//div[@data-formtitle='Payrolls']//div[@class='btn btn-primary btn-sm']")
    WebElementFacade refreshPageButton;

    @FindBy(xpath =
            "//div[@class='d-flex flex-column justify-content-around pl-2']//div[contains(.,' Start New Payroll ')]")
    WebElementFacade startNewPayrollButton;

    @FindBy(xpath =
            "//div[@class='d-flex flex-column justify-content-around pl-2']//div[contains(.,' Create Next Payroll ')]")
    WebElementFacade createNextPayrollButton;

    @FindBy(xpath =
            "//span[@class='total-pages']")
    WebElementFacade pagesNumber;

    @FindBy(xpath =
            "//div[@class='btn btn-default btn-sm fragment-pagination-next mr-2']")
    WebElementFacade nextButton;

    @FindAll(@FindBy(xpath =
            "//div[@type='button']//i[@class='fa fa-reply fa-flip-horizontal']"))
    List<WebElement> dropDownMenuArrowList;

    @FindAll(@FindBy(xpath =
            "//tbody[@tabindex='1']//div[@type='button']//i[@class='fa fa-cog']"))
            List<WebElement> dropDownMenuGearList;

    @FindBy(xpath
            = "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr[2]//td[8]")
    WebElementFacade secondPayrollAchStatus;

    @FindBy(xpath
            = "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr[1]/td[1]/a")
    WebElementFacade lastPayrollCheckDate;

    @FindBy(xpath
            = "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr[10]/td[1]/a")
    WebElementFacade firstPayrollCheckDate;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr/td[1]/a"))
    List<WebElement> payrollDateList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr/td[3]"))
    List<WebElement> payrollBeginDateList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr/td[4]"))
    List<WebElement> payrollEndDateList;

    @FindAll(@FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr/td[5]"))
    List<WebElement> payFrequencyList;

    @FindBy(xpath =
            "//div[@class='dropdown-menu dropdown-menu-right show']//a[contains(.,'Create Payroll Checks')]")
    WebElementFacade createPayrollChecks;

    @FindBy(xpath =
            "//div[@class='dropdown-menu dropdown-menu-right show']//a[@data-title='Payroll Checks']")
    WebElementFacade payrollChecksOption;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']//div[contains(.,'Calculate All Checks')]")
    WebElementFacade calculateAllChecks;

    BasicInteractions basicInteractions;

    public static String lastPayCheckDate;
    public static String newPayCheckDate;
    public static String lastPeriodBeginDate;
    public static String newPeriodBeginDate;
    public static String lastPeriodEndDate;
    public static String newPeriodEndDate;
    public static String estNewPeriodBeginDate;
    public static String estNewPeriodEndDate;
    public static String numberOfPages;
    public String payFrequency;
    public static int checkNumber = 0;


    public void refreshPage() {
        basicInteractions.waitingTimeOUT(3000);
        basicInteractions.clickIfButtonEnabled(refreshPageButton);
    }

    public void createNextPayroll() {
        basicInteractions.waitingTimeOUT(1000);
        basicInteractions.clickIfElementEnabled(createNextPayrollButton);
    }

    public void selectLastPayrollDates() {
        basicInteractions.waitingTimeOUT(500);
        lastPayrollCheckDate.shouldBeVisible();
        lastPayCheckDate = payrollDateList.get(0).getText();
        lastPeriodEndDate = payrollEndDateList.get(0).getText();
    }

    public void openDropDownMenuGearForLastPayroll() {
        lastPayrollCheckDate.shouldBeVisible();
        basicInteractions.clickIfLastLIstElemDisplayed(dropDownMenuGearList);
    }

    public void openDropDownMenuArrowForLastPayroll() {
        lastPayrollCheckDate.shouldBeVisible();
        basicInteractions.clickIfLastLIstElemDisplayed(dropDownMenuArrowList);
    }

    public void selectCreatePayrollChecks(){
        basicInteractions.ifElementEnabled(createPayrollChecks, basicInteractions);
    }

    public void selectCalculateAllChecksOption(){
        basicInteractions.ifElementEnabled(calculateAllChecks, basicInteractions);
    }

    public void selectPayrollChecksOption(){
        basicInteractions.ifElementEnabled(payrollChecksOption, basicInteractions);
    }

    public void selectPayrollWithGivenCheckDate(String givenCheckDate){
        basicInteractions.waitingTimeOUT(500);
        payrollDateList.get(payrollDateList.size()-1).isDisplayed();
        for (int i = 0; i < payrollDateList.size(); i++) {
            if (payrollDateList.get(i).isEnabled()) {
                if (payrollDateList.get(i).getText().equals(givenCheckDate)) {
                    dropDownMenuArrowList.get(i).click();
                    break;
                } else {
                    continue;
                }
            } else {
                System.out.println("createNextPayroll is not clickable on drop-down menu");
            }
        }
    }
      /*public int getCheckNumber(String givenCheckDate) {
        payrollDateList.get(payrollDateList.size()-1).isDisplayed();
        for (int i = 0; i < payrollDateList.size(); i++) {
            if (payrollDateList.get(i).isEnabled()) {
                if (payrollDateList.get(i).getText().equals(givenCheckDate)) {
                    chosenCheckDate = payrollDateList.get(i).getText();
                    System.out.println("chosenCheckDate " + chosenCheckDate);
                    checkNumber = i;
                    System.out.println("checkNumber " + checkNumber);
                    break;
                } else {
                    continue;
                }
            } else {
                System.out.println("createNextPayroll is not clickable on drop-down menu");
            }
        }
        return checkNumber;
    }*/

    /*public void openDropDownMenuArrow() {
        dropDownMenuArrowList.get(dropDownMenuArrowList.size()-1).isDisplayed();
        for (int i = 0; i < dropDownMenuArrowList.size(); i++) {
            if (i==checkNumber) {
                if (firstPayrollCheckDate.isDisplayed()) {
                    dropDownMenuArrowList.get(i).click();
                } else {
                    System.out.println("firstPayrollCheckDate is not Displayed");
                }
                break;
            } else {
                continue;
            }
        }
    }*/

    public void openDropDownMenuArrow() {
        dropDownMenuArrowList.get(dropDownMenuArrowList.size()-1).isDisplayed();
        for (int i = 0; i < dropDownMenuArrowList.size(); i++) {
            if (i==checkNumber) {
                if (firstPayrollCheckDate.isDisplayed()) {
                    dropDownMenuArrowList.get(i).click();
                } else {
                    System.out.println("firstPayrollCheckDate is not Displayed");
                }
                break;
            } else {
                continue;
            }
        }
    }


    public void selectNewPayrollDates() {
        basicInteractions.waitingTimeOUT(2000);
        if (payrollDateList.get(payrollDateList.size()-1).isDisplayed()){
            newPayCheckDate = payrollDateList.get(0).getText();
            newPeriodBeginDate = payrollBeginDateList.get(0).getText();
            newPeriodEndDate = payrollEndDateList.get(0).getText();
        } else {
            System.out.println("Last payroll is not displayed on the screen");
        }
    }

    public void getsPayFrequency() {
        waitForPresenceOf
                ("//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr/td[5]");
        payFrequency = payFrequencyList.get(0).getText();
        System.out.println("payFrequency " + payFrequency);
    }



    public Date transformToDate(String dateAsString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    public void verifyPayFrequencyForLastPayroll(String payFrequency) {
        basicInteractions.assertEqualsIfListElementEnabled(payFrequency, payFrequencyList
                                            , 0, basicInteractions);
    }

    public void verifyPayFrequency(String payFrequency) {
        basicInteractions.assertEqualsIfListElementEnabled(payFrequency, payFrequencyList
                                            , checkNumber, basicInteractions);
    }

    public void verifyTimeDifference(){
        Date date1 = transformToDate(lastPayCheckDate);
        Date date2 = transformToDate(newPayCheckDate);
        int days = Days.daysBetween(new DateTime(date1), new DateTime(date2)).getDays();

        Integer daysForTr = new Integer(days);
        System.out.println(days + " days");


        if (payFrequency.equals("Weekly")) {
            Assert.assertEquals(days, 7);
        } else if (payFrequency.equals("Every Two Weeks")) {
            Assert.assertEquals(days, 14);
        } else if (payFrequency.equals("Monthly")) {
            assertThat(daysForTr.toString(), anyOf(
                    containsString("30"),
                    containsString("31"),
                    containsString("28"),
                    containsString("29")));
        } else if (payFrequency.equals("Daily")) {
            Assert.assertEquals(days, 1);
        }
        else {
            System.out.println("Incorrect condition");
        }
    }

    public void verifyPeriodBeginDate() throws ParseException {
        Calendar cal = Calendar.getInstance();
        DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        cal.setTime(date.parse(lastPeriodEndDate));
        cal.add(Calendar.DATE, 1 );
        String expPeriodBeginDate = date.format(cal.getTime());

        Assert.assertEquals(expPeriodBeginDate, newPeriodBeginDate);
        System.out.println("newPeriodBeginDate " + newPeriodBeginDate);
        System.out.println("expPeriodBeginDate " + expPeriodBeginDate);

    }

    public void verifyPeriodEndDate() throws ParseException {
        Calendar cal = Calendar.getInstance();
        DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        cal.setTime(date.parse(lastPeriodEndDate));

        if (payFrequency.equals("Weekly")) {
            cal.add(Calendar.DATE, 7);
            String expPeriodEndDate = date.format(cal.getTime());
            Assert.assertEquals(expPeriodEndDate, newPeriodEndDate);
            System.out.println("newPeriodEndDate " + newPeriodEndDate);
            System.out.println("expPeriodEndDate " + expPeriodEndDate);
        } else if (payFrequency.equals("Every Two Weeks")) {
            cal.add(Calendar.DATE, 14);
            String expPeriodEndDate = date.format(cal.getTime());
            Assert.assertEquals(expPeriodEndDate, newPeriodEndDate);
            System.out.println("newPeriodEndDate " + newPeriodEndDate);
            System.out.println("expPeriodEndDate " + expPeriodEndDate);
        } else if (payFrequency.equals("Monthly")) {
            cal.add(Calendar.MONTH, 1 );
            String expPeriodEndDate = date.format(cal.getTime());
            Assert.assertEquals(expPeriodEndDate, newPeriodEndDate);
            System.out.println("newPeriodEndDate " + newPeriodEndDate);
            System.out.println("expPeriodEndDate " + expPeriodEndDate);
        } else if (payFrequency.equals("Daily")) {
            cal.add(Calendar.DATE, 1 );
            String expPeriodEndDate = date.format(cal.getTime());
            Assert.assertEquals(expPeriodEndDate, newPeriodEndDate);
            System.out.println("newPeriodEndDate " + newPeriodEndDate);
            System.out.println("expPeriodEndDate " + expPeriodEndDate);
        } else {
            System.out.print("Incorrect condition");
        }
    }

    public int verifyNumberOfPayrolls() {
        String numberOfPages = pagesNumber.getText();
        System.out.println("numberOfPages " + numberOfPages);
        int pages = Integer.parseInt(numberOfPages);
        int count = 0;
        for (int i = 0; i < pages; i++) {
            if (nextButton.isCurrentlyVisible()) {
                nextButton.click();
                count = count + payrollDateList.size();
            } else {
                System.out.println("NextButton is not clickable");
            }
        }
        System.out.println("Number of payrolls " + count);
        return count;
    }

    public void getDatesForLastPayroll() {
        basicInteractions.waitingTimeOUT(2000);
        if (payrollDateList.get(payrollDateList.size()-1).isDisplayed()){
            lastPayCheckDate = payrollDateList.get(0).getText();
            lastPeriodBeginDate = payrollBeginDateList.get(0).getText();
            lastPeriodEndDate = payrollEndDateList.get(0).getText();
        } else {
            System.out.println("Last payroll is not displayed on the screen");
        }
    }

    public void getBeginDateForNewPayroll() throws ParseException {
        if (payrollDateList.get(payrollDateList.size()-1).isDisplayed()){
            Calendar cal = Calendar.getInstance();
            DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            cal.setTime(date.parse(lastPeriodEndDate));
            cal.add(Calendar.DATE, 1 );
            estNewPeriodBeginDate = date.format(cal.getTime());
            //System.out.println("estNewPeriodBeginDate "+estNewPeriodBeginDate);
        } else {
            System.out.println("Last payroll is not displayed on the screen");
        }
    }

    public void getEndDateForNewPayroll() throws ParseException {
        if (payrollDateList.get(payrollDateList.size()-1).isDisplayed()){
            Calendar cal = Calendar.getInstance();
            DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            cal.setTime(date.parse(lastPeriodEndDate));
            cal.add(Calendar.DATE, 7 );
            estNewPeriodEndDate = date.format(cal.getTime());
            //System.out.println("estNewPeriodEndDate "+estNewPeriodEndDate);
        } else {
            System.out.println("Last payroll is not displayed on the screen");
        }
    }

    public void selectPayrollWithGivenDate(String givenCheckDate) {
        basicInteractions.waitingTimeOUT(1500);
        pagesNumber.shouldBeCurrentlyVisible();
        numberOfPages = pagesNumber.getText();

        String chosenCheckDate = " ";

        int pages = Integer.parseInt(numberOfPages);
        for (int i = 0; i < pages; i++) {
            basicInteractions.waitingTimeOUT(1500);
                if (payrollDateList.get(payrollDateList.size()-1).isEnabled()){
                    for (int j = 0; j < payrollDateList.size(); j++) {
                        if (payrollDateList.get(j).getText().equals(givenCheckDate)) {
                            chosenCheckDate = payrollDateList.get(j).getText();
                            payFrequency = payFrequencyList.get(j).getText();
                            dropDownMenuArrowList.get(j).click();
                            checkNumber = j;
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (chosenCheckDate.equals(" ")){
                        nextButton.click();
                        continue;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Last element of list is not enabled");
                }
        }
    }

    public void clickCalculateNewPayroll() {
        basicInteractions.waitingTimeOUT(1000);
        startNewPayrollButton.click();
    }
}
