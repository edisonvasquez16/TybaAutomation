package com.tyba.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Back implements Task {

    public static Back page() {
        return instrumented(Back.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().navigate().back();
    }
}
