package com.tyba.ui.shopping;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderPayment {

    public static final Target NEXT = Target.the("next button")
            .located(By.id("next_btn"));

    public static final Target USERNAME = Target.the("input safe pay username")
            .located(By.name("safepay_username"));

    public static final Target PASSWORD = Target.the("input safe pay password")
            .located(By.name("safepay_password"));

    public static final Target PAY_NOW = Target.the("pay now button")
            .located(By.id("pay_now_btn_SAFEPAY"));
}
