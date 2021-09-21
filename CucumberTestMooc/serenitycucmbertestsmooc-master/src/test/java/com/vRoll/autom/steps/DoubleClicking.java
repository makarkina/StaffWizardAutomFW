package com.vRoll.autom.steps;

import com.vRoll.autom.pages.CompanyPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DoubleClicking implements Performable {

    CompanyPage companyPage;

   public <T extends Actor> void performAs(T actor) {
  /*      actor.attemptsTo(DoubleClick.on(companyPage.element(By
                .xpath("//tr[@data-itemdescription='GuardHub']")))); */
    }
    public static Performable doubleClickOnElement() {
        return Instrumented.instanceOf(DoubleClicking.class).newInstance();
    }

}


