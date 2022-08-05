package com.tyba.consequences.shopping;

import com.tyba.models.shopping.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static com.tyba.ui.shopping.Cart.ITEM_PRODUCT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SeeThatItemsIn implements Task {

    private final List<Product> products;

    public SeeThatItemsIn(List<Product> products) {
        this.products = products;
    }

    public static SeeThatItemsIn cart(List<Product> products) {
        return instrumented(SeeThatItemsIn.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        products.forEach(
                product ->
                        actor.should(
                                seeThat(
                                        the(ITEM_PRODUCT.of(
                                                        product.getName(),
                                                        String.valueOf(product.getQuantity()),
                                                        product.getTotalAmountForItem()
                                                )
                                        ),
                                        isVisible()))
        );
    }
}
