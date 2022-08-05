package com.tyba.tasks;

import com.tyba.interactions.AddItemToCart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AddItemTo implements Task {

    private final List<Performable> itemsAddCart;

    public AddItemTo() {
        itemsAddCart = new ArrayList<>();
    }

    public static AddItemTo cart() {
        return instrumented(AddItemTo.class);
    }

    public AddItemTo selectItem(String itemNumber) {
        this.itemsAddCart.add(AddItemToCart.selectItem(itemNumber));
        return this;
    }

    public AddItemTo selectColor(String color) {
        this.itemsAddCart.add(AddItemToCart.selectColor(color));
        return this;
    }

    public AddItemTo selectQuantity(int quantity) {
        for (int x = 1; x <= quantity - 1; x++) {
            this.itemsAddCart.add(AddItemToCart.addQuantity());
        }
        return this;
    }

    public AddItemTo andAddProduct() {
        this.itemsAddCart.add(AddItemToCart.addProduct());
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                addItemCartActions()
        );
    }

    private Performable[] addItemCartActions() {
        return this.itemsAddCart.toArray(new Performable[this.itemsAddCart.size()]);
    }
}