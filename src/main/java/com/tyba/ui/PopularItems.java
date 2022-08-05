package com.tyba.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PopularItems {

    public static final Target TITLE_SECTION = Target.the("Title section")
            .locatedBy("//h3[contains(text(),'POPULAR ITEMS')]");

    public static final Target ACCESS_DETAILS = Target.the("Access details popular items")
            .locatedBy("(//label[contains(text(),'View Details')])[{0}]");

}
