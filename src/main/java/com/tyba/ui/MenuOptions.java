package com.tyba.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuOptions {

    public static final Target MENU_OPTION = Target.the("item option")
            .locatedBy("//a[contains(text(),'{0}')]");

    public static final Target PROFILE_OPTION = Target.the("profile option")
            .located(By.id("menuUserLink"));

    public static final Target CREATE_ACCOUNT_OPTION = Target.the("create account option")
            .locatedBy("//a[contains(text(),'CREATE NEW ACCOUNT')]");

    public static final Target MENU_CART_OPTION = Target.the("menu cart option")
            .located(By.id("shoppingCartLink"));

    public static final Target LIST_CART = Target.the("list temporal cart")
            .located(By.id("toolTipCart"));

}