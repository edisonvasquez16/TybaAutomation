package com.tyba.ui.shopping;

import net.serenitybdd.screenplay.targets.Target;

public class ProductDetails {

    public static final Target ITEM_COLOR_SELECTED = Target.the("Item color radio selected")
            .locatedBy("//span[@title='{0}']");


    public static final Target ITEM_COLOR = Target.the("Item color radio")
            .locatedBy("//span[@title='{0}']");

    public static final Target QUANTITY_PRODUCT_ADD = Target.the("Quantity product input")
            .locatedBy("//div[@increment-value-attr='+']");

    public static final Target ADD_TO_CART = Target.the("Add to cart button")
            .locatedBy("//button[@name='save_to_cart']");

}