package com.vRoll.autom.actions.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectACompany implements Task {

    public static Target COMPANY_LINE = Target.the("Company row")
            .located(By.xpath("//tr[@data-itemdescription='GuardHub']"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DoubleClick.on(COMPANY_LINE)
        );
    }

    public static Performable usingDoubleClick() {
        return instrumented(SelectACompany.class);
    }
}
