package com.tyba.tasks.shopping;

import com.tyba.interactions.shopping.FinishPaymentSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishPayment implements Task {

    private final List<Performable> itemsFinishPayment;

    public FinishPayment() {
        itemsFinishPayment = new ArrayList<>();
    }

    public static FinishPayment process() {
        return instrumented(FinishPayment.class);
    }

    public FinishPayment nextStep() {
        this.itemsFinishPayment.add(FinishPaymentSteps.nextStep());
        return this;
    }

    public FinishPayment enterUsername(String username) {
        this.itemsFinishPayment.add(FinishPaymentSteps.enterUsername(username));
        return this;
    }

    public FinishPayment enterPassword(String password) {
        this.itemsFinishPayment.add(FinishPaymentSteps.enterPassword(password));
        return this;
    }

    public FinishPayment andPayNow() {
        this.itemsFinishPayment.add(FinishPaymentSteps.payNow());
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                addItemCartActions()
        );
    }

    private Performable[] addItemCartActions() {
        return this.itemsFinishPayment.toArray(new Performable[this.itemsFinishPayment.size()]);
    }
}
