package com.tyba.consequences.shopping;

import com.tyba.models.shopping.ExampleData;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.questions.Text;

import static com.tyba.ui.shopping.Cart.TOTAL_AMOUNT;
import static com.tyba.ui.shopping.Cart.TOTAL_ITEMS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatInCart {

    public static Consequence[] totalValues(ExampleData data) {
        return new Consequence[]{
                seeThat(
                        Text.of(TOTAL_AMOUNT), equalTo(data.getTotalAmount())),
                seeThat(
                        the(TOTAL_ITEMS.of(data.getTotalItems())), isVisible())
        };
    }
}
