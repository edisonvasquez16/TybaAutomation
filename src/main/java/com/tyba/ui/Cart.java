package com.tyba.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Cart {

    public static final Target ITEM_PRODUCT = Target.the("Item product in cart")
            .locatedBy("//tr/td/label[contains(string(),'{0}')]/../../td/label[contains(string(),'{1}')]/../../td/p[contains(string(),'{2}')]/../..");

    public static final Target TOTAL_ITEMS = Target.the("total items in cart")
            .locatedBy("//span[contains(text(),'({0})')]");

    public static final Target TOTAL_AMOUNT = Target.the("value total amount")
            .locatedBy("//span[contains(text(),'TOTAL:')]/../span[2]");

    public static final Target CHECKOUT = Target.the("checkout button")
            .located(By.id("checkOutButton"));
}
