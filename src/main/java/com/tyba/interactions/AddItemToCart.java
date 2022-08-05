package com.tyba.interactions;

import com.tyba.utils.Back;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.tyba.ui.Commons.LOADING_IMG;
import static com.tyba.ui.PopularItems.ACCESS_DETAILS;
import static com.tyba.ui.PopularItems.TITLE_SECTION;
import static com.tyba.ui.ProductDetails.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddItemToCart {

    public static Performable selectItem(String itemNumber) {
        return Task.where("{0} select item for add to cart",
                WaitUntil.the(TITLE_SECTION, isVisible()).forNoMoreThan(5).seconds()
                        .then(Click.on(ACCESS_DETAILS.of(itemNumber)))
        );
    }

    public static Performable selectColor(String color) {
        if (!ITEM_COLOR_SELECTED.of(color).resolveFor(theActorInTheSpotlight()).isSelected() && ITEM_COLOR_SELECTED.of(color).resolveFor(theActorInTheSpotlight()).isClickable())
            return Task.where("{0} select color of product",
                    Click.on(ITEM_COLOR.of(color))
            );
        else
            return Task.where("Color of product already selected");

    }

    public static Performable addQuantity() {
        return Task.where("{0} select quantity of product",
                Click.on(QUANTITY_PRODUCT_ADD));
    }

    public static Performable addProduct() {
        return Task.where("{0} add product to cart",
                Click.on(ADD_TO_CART)
                        .then(WaitUntil.the(LOADING_IMG, isNotVisible()))
                        .then(Back.page())
        );
    }
}