package com.tyba.tasks;

import com.tyba.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddItemsTo implements Task {

    private final List<Product> products;

    public AddItemsTo(List<Product> products) {
        this.products = products;
    }

    public static AddItemsTo cart(List<Product> products) {
        return instrumented(AddItemsTo.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int x = 0; x <= products.size() - 1; x++) {
            actor.attemptsTo(
                    AddItemTo
                            .cart()
                            .selectItem(String.valueOf(x + 1)));
            actor.attemptsTo(
                    AddItemTo
                            .cart()
                            .selectColor(products.get(x).getColor())
                            .selectQuantity(products.get(x).getQuantity())
                            .andAddProduct());
        }
    }
}
