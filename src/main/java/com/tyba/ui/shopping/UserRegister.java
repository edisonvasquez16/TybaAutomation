package com.tyba.ui.shopping;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserRegister {

    public static final Target USERNAME = Target.the("")
            .located(By.name("usernameRegisterPage"));

    public static final Target EMAIL = Target.the("")
            .located(By.name("emailRegisterPage"));

    public static final Target PASSWORD = Target.the("")
            .located(By.name("passwordRegisterPage"));

    public static final Target CONFIRM_PASSWORD = Target.the("")
            .located(By.name("confirm_passwordRegisterPage"));

    public static final Target FIRSTNAME = Target.the("")
            .located(By.name("first_nameRegisterPage"));

    public static final Target LASTNAME = Target.the("")
            .located(By.name("last_nameRegisterPage"));

    public static final Target PHONE_NUMBER = Target.the("")
            .located(By.name("phone_numberRegisterPage"));

    public static final Target COUNTRY = Target.the("")
            .located(By.name("countryListboxRegisterPage"));

    public static final Target CITY = Target.the("")
            .located(By.name("cityRegisterPage"));

    public static final Target ADDRESS = Target.the("")
            .located(By.name("addressRegisterPage"));

    public static final Target STATE = Target.the("")
            .located(By.name("state_/_province_/_regionRegisterPage"));

    public static final Target POSTAL_CODE = Target.the("")
            .located(By.name("postal_codeRegisterPage"));

    public static final Target AGREE_CONDITIONS = Target.the("")
            .located(By.name("i_agree"));

    public static final Target REGISTER = Target.the("")
            .located(By.id("register_btnundefined"));


}
