package io.qameta.allure.examples;

import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class AllureStepTest {

    @Test
    public void allureSimpleStepTest() {
        step("Simple step");
        step("Simple step with failed status", Status.FAILED);
        step("Simple step with skipped status", Status.SKIPPED);
        step("Simple step with broken status", Status.BROKEN);
        step("Simple step with passed status", Status.PASSED);
    }

    @Test
    public void allureLambdaStepTest() {
        step("Simple lambda step", () -> {
            step("Simple step inside lambda step");
        });

        step("Lambda step with parameter", (step) -> {
            step.parameter("param", "value");
            //parameter("test param", "value2");
        });

        step("Old step name", (step) -> {
            step.name("Dynamic step name");
        });
    }

    @Test
    public void allureStepAnnotationTest() {
        simpleTestMethod();
        parametrizedTestMethod("method parameter");
        parametrizedWithFieldTestMethod("field parameter");
    }


    @Step("Parametrized test method with step annotation'")
    public void parametrizedTestMethod(String param) {
        step("Method parameter: " + param);
    }

    @Step("Parametrized test method with fields: '{param}'")
    public void parametrizedWithFieldTestMethod(String param) {

    }

    @Step("Simple test method with step annotation")
    public void simpleTestMethod() {
        step("Simple step inside test method");
    }

}
