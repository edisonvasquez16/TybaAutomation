package com.tyba.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FinishedPayment {

    public static final Target USER_NAME = Target.the("")
            .located(By.id("(//div[@class='seccion borderRight']/div/div/label)[1]"));

    public static final Target ADDRESS = Target.the("")
            .located(By.id("(//div[@class='seccion borderRight']/div/div/label)[2]"));

    public static final Target CITY = Target.the("")
            .located(By.id("(//div[@class='seccion borderRight']/div/div/label)[3]"));

    public static final Target STATE = Target.the("")
            .located(By.id("(//div[@class='seccion borderRight']/div/div/label)[4]"));

    public static final Target USER_PHONE_NUMBER = Target.the("")
            .located(By.id("(//div[@class='seccion borderRight']/div/div/label)[5]"));

    public static final Target PAYMENT_DATE = Target.the("")
            .locatedBy("//label[contains(string(),'Date ordered')]/a");

    public static final Target SUMMARY_SUBTOTAL = Target.the("")
            .locatedBy("//label[contains(string(),'Subtotal')]/a");

    public static final Target SUMMARY_SHIPPING = Target.the("")
            .locatedBy("//label[contains(string(),'shipping')]/a");

    public static final Target SUMMARY_TOTAL = Target.the("")
            .locatedBy("//label[contains(string(),'TOTAL')]/a");


}
