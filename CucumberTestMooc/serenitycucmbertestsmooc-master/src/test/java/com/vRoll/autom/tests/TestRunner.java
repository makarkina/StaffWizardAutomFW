package com.vRoll.autom.tests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/newCheckDetailsVerificationOnGivenDate.feature",
                    glue = "com.vRoll.autom.steps")

public class TestRunner {
}
