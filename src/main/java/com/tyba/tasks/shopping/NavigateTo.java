package com.tyba.tasks.shopping;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.tyba.enums.Memory.BASE_URL;
import static com.tyba.enums.shopping.MenuOptions.*;
import static com.tyba.ui.shopping.Cart.CHECKOUT;
import static com.tyba.ui.shopping.Commons.LOADING_IMG;
import static com.tyba.ui.shopping.MenuOptions.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class NavigateTo {

    public static Performable homePage() {
        return Task.where("{0} open the login  page",
                Open.url(theActorInTheSpotlight().recall(BASE_URL.toString())));
    }

    public static Performable ourProducts() {
        return Task.where("{0} access to our products option",
                WaitUntil.the(LOADING_IMG, isNotVisible())
                        .then(Click.on(MENU_OPTION.of(OUR_PRODUCTS.getText())))
        );
    }

    public static Performable specialOffer() {
        return Task.where("{0} access to special offer option",
                WaitUntil.the(LOADING_IMG, isNotVisible())
                        .then(Click.on(MENU_OPTION.of(SPECIAL_OFFER.getText())))
        );
    }

    public static Performable popularItems() {
        return Task.where("{0} access to popular items option",
                WaitUntil.the(LOADING_IMG, isNotVisible())
                        .then(Click.on(MENU_OPTION.of(POPULAR_ITEMS.getText())))
        );
    }

    public static Performable contactUs() {
        return Task.where("{0} access to contact us option",
                WaitUntil.the(LOADING_IMG, isNotVisible())
                        .then(Click.on(MENU_OPTION.of(CONTACT_US.getText())))
        );
    }

    public static Performable menuCartOption() {
        return Task.where("{0} access to menu cart option",
                MoveMouse.to(MENU_CART_OPTION)
                        .then(Click.on(MENU_CART_OPTION))
        );
    }

    public static Performable checkoutCart() {
        return Task.where("{0} access to menu cart option",
                Scroll.to(CHECKOUT).andAlignToBottom()
                        .then(MoveMouse.to(CHECKOUT))
                        .then(Click.on(CHECKOUT))
        );
    }

    public static Performable registerForm() {
        return Task.where("{0} access to register form",
                WaitUntil.the(LOADING_IMG, isNotVisible())
                        .then(Click.on(PROFILE_OPTION))
                        .then(Click.on(CREATE_ACCOUNT_OPTION))
        );
    }
}