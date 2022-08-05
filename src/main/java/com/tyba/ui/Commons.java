package com.tyba.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Commons {

    public static final Target LOADING_IMG = Target.the("Loading image")
            .locatedBy("div.loader[style='display: block; opacity: 1;']");

}