package com.tyba.interactions.shopping;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.tyba.ui.shopping.Commons.LOADING_IMG;
import static com.tyba.ui.shopping.OrderPayment.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class FinishPaymentSteps {

    public static Performable nextStep() {
        return Task.where("{0} advance to next step",
                Scroll.to(NEXT).andAlignToBottom()
                        .then(Click.on(NEXT)));
    }

    public static Performable enterUsername(String username) {
        return Task.where("{0} enter de username of payment",
                Enter.theValue(username).into(USERNAME));
    }

    public static Performable enterPassword(String password) {
        return Task.where("{0} enter the password of payment",
                Enter.theValue(password).into(PASSWORD));
    }

    public static Performable payNow() {
        return Task.where("{0} pay the cart",
                Scroll.to(PAY_NOW).andAlignToBottom()
                        .then(Click.on(PAY_NOW))
                        .then(WaitUntil.the(LOADING_IMG, isNotVisible())));
    }
}
