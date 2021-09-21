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
            "//div[@class='card-body p-0 d-flex']//tr//td//div[@type='button']//i[@class='fa fa-reply fa-flip-horizontal']"))
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

    @FindBy(xpath
            = "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr[2]/td[1]/a")
    WebElementFacade previousPayrollCheckDate;

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
    List<WebElement> payrollPayFrequencyList;

    @FindBy(xpath =
            "//section[@id='main-container']//div[@data-fragment='forms/payroll/list']//tr[1]//th[1]")
    WebElementFacade checkDateSign;

    @FindBy(xpath = "//div[@data-sortkey='checkdate']")
    WebElementFacade sortChecksSign;

    @FindBy(xpath =
            "//div[@class='dropdown-menu dropdown-menu-right show']//div[@class='dropdown-item ']")
    WebElementFacade createNextPayroll;

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
    public static String trNewPeriodBeginDate;
    public String chosenCheckDate;
    public String payFrequency;
    public int checkNumber = 0;


    public void refreshPage() {
        basicInteractions.waitingTimeOUT(3000);
        basicInteractions.ifElementDisplayed(refreshPageButton, basicInteractions);
    }


    public void addNewPayroll() {
        basicInteractions.ifElementDisplayed(startNewPayrollButton, basicInteractions);
        basicInteractions.waitingTimeOUT(3000);
    }

    public void createNextPayroll() {
        basicInteractions.waitingTimeOUT(3000);
        basicInteractions.ifElementDisplayed(createNextPayrollButton, basicInteractions);
    }

    public void selectLastPayrollDates() {
        basicInteractions.waitingTimeOUT(1500);
        lastPayrollCheckDate.shouldBeVisible();
        lastPayCheckDate = payrollDateList.get(0).getText();
        lastPeriodEndDate = payrollEndDateList.get(0).getText();
        System.out.println("lastPayCheckDate " + lastPayCheckDate);
    }

    public int getCheckNumber(String givenCheckDate) {
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
    }

    public void openDropDownMenuArrow() {
       if (dropDownMenuArrowList.get(dropDownMenuArrowList.size()-1).isDisplayed()) {
            for (int i = 0; i < dropDownMenuArrowList.size(); i++) {
                if (i==checkNumber) {
                    basicInteractions.clickIfListOfElementsDisplayed(i, dropDownMenuArrowList,dropDownMenuArrowList.size()-1,
                                        "dropDownMenuArrow for last payroll is not clickable");
                    break;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("dropDownMenuArrow for last payroll is not clickable");
        }
    }

    public void openDropDownMenuGearForLastPayroll() {
        payrollDateList.get(payrollDateList.size()-1).isDisplayed();
        basicInteractions.clickIfGivenElementOfListDisplayed(dropDownMenuGearList.get(0),
                "dropDownMenuGear for last payroll is not clickable");
    }

    public void selectCreatePayrollChecks(){
        basicInteractions.ifElementDisplayed(createPayrollChecks, basicInteractions);
    }

    public void selectCalculateAllChecksOption(){
        basicInteractions.ifElementDisplayed(calculateAllChecks, basicInteractions);
    }

    public void selectPayrollChecks(){
        basicInteractions.ifElementDisplayed(payrollChecksOption, basicInteractions);
    }

    public void verifyCheckDate(String givenCheckDate) {
        if (payrollDateList.get(payrollDateList.size()-1).isDisplayed()){
            System.out.println("chosenCheckDate " + chosenCheckDate + " givenCheckDate " + givenCheckDate);
            Assert.assertEquals(chosenCheckDate, givenCheckDate);
        } else {
            System.out.println("Last payroll is not displayed on the screen");
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
        payFrequency = payrollPayFrequencyList.get(0).getText();
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
        } else {
            System.out.print("Incorrect condition");
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
        cal.setTime(date.parse(newPeriodBeginDate));
        if (payFrequency.equals("Weekly")) {
            cal.add(Calendar.DATE, 6 );
            String expPeriodEndDate = date.format(cal.getTime());
            Assert.assertEquals(expPeriodEndDate, newPeriodEndDate);
            System.out.println("newPeriodEndDate " + newPeriodEndDate);
            System.out.println("expPeriodEndDate " + expPeriodEndDate);
        } else if (payFrequency.equals("Every Two Weeks")) {
            cal.add(Calendar.DATE, 13 );
            String expPeriodEndDate = date.format(cal.getTime());
            Assert.assertEquals(expPeriodEndDate, newPeriodEndDate);
            System.out.println("newPeriodEndDate " + newPeriodEndDate);
            System.out.println("expPeriodEndDate " + expPeriodEndDate);
        } else if (payFrequency.equals("Monthly")) {
            cal.add(Calendar.MONTH, 1 );
            cal.add(Calendar.DATE, -1 );
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
                //System.out.println("Number of payrolls " + count);
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
            System.out.println("estNewPeriodBeginDate "+estNewPeriodBeginDate);
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
            System.out.println("estNewPeriodEndDate "+estNewPeriodEndDate);

        } else {
            System.out.println("Last payroll is not displayed on the screen");
        }
    }


}